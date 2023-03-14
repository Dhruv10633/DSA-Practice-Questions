//https://leetcode.com/problems/jump-game-ii/
package Questions.DP;

class Solution {
    public int jump(int[] nums) {
        return soln(nums, 0, new int[nums.length]);
    }

    private int soln(int[] nums, int i, int[] dp){
        if(i>=nums.length-1){
            return 0;
        }
        
        //if we have already calculated the min steps
        if(dp[i]!=0) return dp[i];

        int steps=10000;

        //we check for all possible number of steps that we can take from that particular step
        for(int j=1 ; j<=nums[i] ; j++){
            
            //to check if after going to some step(that's not the dest.) we do not encounter 0
            if(i+j < nums.length-1 && nums[i+j]==0) continue;
            
            steps = Math.min(steps, 1 + soln(nums, i+j, dp));

        }
        return dp[i]=steps;
    }
}
