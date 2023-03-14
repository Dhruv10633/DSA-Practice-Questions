//https://leetcode.com/problems/4sum/
package Arrays_Strings;
import java.util.*;

public class Q5_4_Sum {
    
    public static List<List<Integer>> fourSum(int[] arr, int target) {

        List<List<Integer>> ans=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=0 ; i<n ; i++){
            //both these cond important
            if(i-1>=0 && arr[i-1]==arr[i]){
                continue;
            }
            for(int j=i+1 ; j<n ; j++){
                //this one too
                if(j-1>=i+1 && arr[j-1]==arr[j]){
                    continue;
                }

                int l=j+1,h=n-1;

                while(l<h){
                    long sum=(long)arr[i] + (long)arr[j] + (long)arr[l] + (long)arr[h];

                    if(sum==target){
                        // System.out.println(sum);
                        List<Integer> li=new ArrayList<>();
                        li.add(arr[i]);
                        li.add(arr[j]);
                        li.add(arr[l]);
                        li.add(arr[h]);
                        ans.add(li);
                        while(l<h && arr[l]==arr[l+1]){
                            l++;
                        }
                        while(l<h && arr[l]==arr[h-1]){
                            h--;
                        }
                        
                        l++;
                        h--;
                    }
                    else if(sum<target){
                        l++;
                    }
                    else{
                        h--;
                    }
                }
            }
        }
        return ans;
        
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int target=sc.nextInt();

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        List<List<Integer>> ans = fourSum(arr, target);

        System.out.println(ans.toString());
        sc.close();
    }

}
