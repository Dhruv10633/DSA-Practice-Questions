//https://leetcode.com/problems/squares-of-a-sorted-array/description/
package Arrays_Strings;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        
        int s=0 ,e=nums.length-1;
        int index = ans.length-1;
        while(s<=e){
            if(nums[e]*nums[e] >= nums[s]*nums[s]){
                ans[index] = nums[e]*nums[e];
                e--;
            }
            else{
                ans[index] = nums[s]*nums[s];
                s++;
            }
            index--;
        }

        return ans;
    }
}
