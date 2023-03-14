// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/
package Arrays_Strings;
// import java.util.*;

class Solution {
    public static int minOperations(int[] arr, int x) {
        //if we take out the 'x' from total sum of arr.
        //this means we have found a subarr. whose sum = sum_of_arr-x
        //and since we need to remove the min num of num from either sides to achieve the cond,
        //this means the remaining array (whose sum = sum_of_arr-x) should have the max length possible
        //Hence we create a max sliding window to find the subarr_of sum=(sum_of_arr-x)
        int ans=-1;
        int start=0;
        int sum=0;

        for(int i=0;i<arr.length;i++) sum+=arr[i];

        // if the entire array sum is == x we need to remove
        if(sum-x==0) return arr.length;

        int curr_sum=0;
        for(int i=0;i<arr.length;i++){
            curr_sum+=arr[i];
            
            //we need (x-sum of integer from left/right) ==0 
            while(start<i && curr_sum > sum-x ){
               
                curr_sum-=arr[start];
                //  System.out.println(curr_sum+" - "+start);
                start++;
            }
            
            if(curr_sum == sum-x){
                ans=Math.max(ans,(i-start+1));
            }
            
        }
        if( ans!=-1){
            return arr.length-ans;
        }
        return -1;
    }
}

//https://leetcode.com/problems/count-number-of-nice-subarrays/description/
class Solution2 {
    public int numberOfSubarrays(int[] nums, int k) {
        int count=0;
        int odd=0;
        int start=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0) odd++;

            while(start<i && odd>k){
                // System.out.println("Chala");
                if(nums[start]%2!=0) odd--;
                start++;
            }
            if(odd==k) count++;
            
        }
        return count;
        
    }
}