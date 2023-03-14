// https://leetcode.com/problems/subarray-sum-equals-k/
//Find the num of subarr havin sum k
package Arrays_Strings;
import java.util.*;

public class Q11_Prefix_Sum_Subarray_Sum_Equals_K {

    public static int subarraySum_opt(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int n=arr.length;
        int sum=0;
        int count=0;
        map.put(0,1);

        for(int i=0 ;i<n ; i++){
            sum+=arr[i];

            int temp=sum-k;
            if(map.containsKey(temp)) {  
                //we do this instead of count++ because this shows 
                //eg :
                //if that map coord has 2 val;
                //then there are 2 such subarr who have that same sum and those 2 subarr can be removed
                //from curr subarr to get the target thus leading to 2 subarr at that point
                // count++;
                count+=map.get(temp);
            }

            //if map finds value of sum it assigns value+1 to the sum key
            //else it creates a new sum key with value 0(default)+1
            map.put(sum , map.getOrDefault(sum,0) +1);
        }

        return count;
    }   

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr1=new int[n];

        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        System.out.println(subarraySum_opt(arr1,k));
        sc.close();
        
    }
}

// https://leetcode.com/problems/minimum-size-subarray-sum/
// https://leetcode.com/problems/sum-of-subarray-minimums/

