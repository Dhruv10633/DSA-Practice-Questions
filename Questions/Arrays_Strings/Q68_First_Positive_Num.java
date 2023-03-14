// https://leetcode.com/problems/first-missing-positive/
package Arrays_Strings;
import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int i=0;
        while(i<nums.length && nums[i]<0){
            i++;
        }
        if(i==nums.length) return 1;
        
        int diff = nums[i]-1;
        if(diff > 0) return 1;

        for(;i<nums.length-1;i++){
            diff = nums[i+1]-nums[i]-1;
            if(diff > 0){
                return nums[i]+1;
            }
        }

        return nums[i]+1;
    }
}
