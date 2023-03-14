// https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/
package Arrays_Strings;

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int s = 0;
        int lastMin = -1, lastMax = -1;
        long count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= minK && nums[i] <= maxK) {
                lastMin = (nums[i] == minK) ? i : lastMin;
                lastMax = (nums[i] == maxK) ? i : lastMax;
                
                //if we found minK and maxK at least once till this point
                if(lastMin != -1 && lastMax != -1){
                    //we make a pair of the the last Min and Max indices
                    int e = Math.min(lastMin, lastMax);

                    //total number of subarrays till this point
                    count += e-s+1;
                }
            } 
            else {
                s = i+1;
                lastMin = -1;
                lastMax = -1;
            }
        }
        
        return count;
    }
}
