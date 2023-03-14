//https://leetcode.com/problems/3sum/description/

//3 unique triplets
package Arrays_Strings;
import java.util.*;

public class Q4_3_sum {

    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){

            int j=i+1,k=n-1;
            if(i-1>=0 && arr[i-1]==arr[i]){
                continue;
            }
            while(j<k){
                if(arr[i]+arr[j]+arr[k]==0){
                    List<Integer> li=new ArrayList<>();
                    li.add(arr[i]);
                    li.add(arr[j]);
                    li.add(arr[k]);
                    ans.add(li);
                    //for unique
                    while(j<k && arr[j]==arr[j+1]){
                        j++;
                    }
                    while(j<k && arr[k]==arr[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
                else if(arr[i]+arr[j]+arr[k]<0){
                    j++;
                }
                else{
                    k--;
                }
            }
            
        }

        return ans;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();
    }
}
