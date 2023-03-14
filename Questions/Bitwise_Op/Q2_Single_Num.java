//https://leetcode.com/problems/single-number/description/
package Bitwise_Op;

class Solution {
    //XOR of 2 equal nums==0
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans^=nums[i];
        }
        return ans;
    }
}