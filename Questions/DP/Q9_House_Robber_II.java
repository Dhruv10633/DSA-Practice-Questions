//https://leetcode.com/problems/house-robber-ii/description/
package Questions.DP;

class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];

        //if only two houses, we can not rob either of them. 
        // if(nums.length==2) return Math.max(nums[0],nums[1]);

        int dp[]=new int[nums.length];

        //could cause probs with 0
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        //we run the algo from 0 to n-1 and from 1 to n (if we rob the 0th house then we cannot rob the last one)
        // int x = maxRobTD(nums, 0, nums.length-2 ,dp);  //TOP DOWN
        int x = maxRobBU(nums, 0, nums.length-2 ,dp);     //BOTTOM UP

        //we need to assign -1 to the dp and not use the old one 
        //as this time the values are different as we are taking different limits
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }

        // int y = maxRobTD(nums, 1, nums.length-1 ,dp);  //TOP DOWN
        int y = maxRobTD(nums, 1, nums.length-1 ,dp);     //BOTTOM UP

        return Math.max(x,y);
    }

    //TOP DOWN
    private int maxRobTD(int[]nums, int i, int n, int[]dp){
        if(i > n){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }
        
        dp[i] = Math.max(nums[i] + maxRobTD(nums, i+2, n, dp), maxRobTD(nums, i+1, n, dp));

        return dp[i];
    }

    //BOTTOM UP
    private int maxRobBU(int[]nums, int i, int n, int[]dp){
        dp[i] = nums[i];
        dp[i+1] = Math.max(nums[i], nums[i+1]);

        for(int j=i+2 ;j<=n;j++){
            dp[j] = Math.max(nums[j]+dp[j-2], dp[j-1]);
        }
        
        return dp[n];
    }
}
