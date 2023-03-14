//https://leetcode.com/problems/maximum-sum-circular-subarray/description/
package Arrays_Strings;

class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        
        int min_sum=Integer.MAX_VALUE,min_s=0;   
        int max_sum=Integer.MIN_VALUE,max_s=0;
        int sum=0;

        for(int i=0;i<arr.length;i++){
            //Normal sum
            sum+=arr[i];

            //Kadane's algo for min sum
            min_s+=arr[i];
            min_sum=Math.min(min_sum,min_s);
            if(min_s>0) min_s=0;

            //Kadane's algo for max sum
            max_s+=arr[i];
            max_sum=Math.max(max_sum,max_s);
            if(max_s<0) max_s=0;

        }

        //all -ve , then the max poss sum is max_sum
        if(max_sum<0){
            return max_sum;
        }

        //this basically means is that answer is either:
        //1. Max subarr sum (not circular)
        //2. circular arr sum after removing the subarr with the min_sum 
        return Math.max(max_sum,sum-min_sum);
    }
}
