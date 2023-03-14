// https://leetcode.com/problems/patching-array/description/
package Arrays_Strings;

class Solution {
    public int minPatches(int[] nums, int n) {
        /*Iterating the nums[], and keeps adding them up, and we are getting a running sum. 
        At any position, if nums[i] > sum+1, then we are sure we have to patch a sum+1 
        because all nums before index i can't make sum+1 even if we add all of them up, 
        and all nums after index i are all simply too large.*/

        long sum=0;
        int count=0;
        for(int i=0 ; i<nums.length ; i++){
            if(sum>=n) break;
            while(sum+1 < nums[i] && sum<n){
                sum += sum+1;
                count++;
            }
            sum += nums[i];
        }

        //when we reach the last pos of the arr
        while(sum+1 < n){
            sum += sum+1;
            count++;
        }

        return count;
    }
}
