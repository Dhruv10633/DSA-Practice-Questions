// https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
package Arrays_Strings;

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int len0=0, sum=0;
        long count=0; 

        for(int i=0;i<nums.length;i++){
            //add the curr num
            sum += nums[i];

            //if the sum < or > 0, we reset the sum and the length of '0' subarr and move on
            if(sum!=0){
                sum=0;
                len0=0;
                continue;
            }

            len0++;
            count += len0;
            
        }

        return count;
    }
}
