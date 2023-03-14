// https://leetcode.com/problems/longest-increasing-subsequence/description/
package DP;

class Solution {
    public int lengthOfLIS(int[] nums) {
        //dp array for storing previous Indexes(as if we have that same prev index repeated before then we can staright away return the val)
        int[][] dp = new int[nums.length+1][nums.length+1];

        //Memoization
        // for(int[] arr: dp){
        //     Arrays.fill(arr,-1);
        // }
        // return solveMem(nums, 0, -1, dp); 

        //Tabulation 
        return solveTab(nums, dp);

        //For sPace opt (just create 2 arrays : 1 curr and 1 prev)

    }


    private int solveTab(int[] nums, int[][] dp){

        for(int i = nums.length-1 ; i>=0 ; i--){
            for(int prevIndex = i-1 ; prevIndex>=-1 ; prevIndex--){

                int pick = 0, notPick = 0;

                if(prevIndex==-1 || nums[prevIndex] < nums[i]){  
                    //dp[i+1][i+1]:
                    //1st [i+1] refers to the prev i we solved
                    //2nd [i+1] refers to the  
                    pick = 1 + dp[i+1][i+1];
                }

                notPick = dp[i+1][prevIndex+1];

                dp[i][prevIndex+1] = Math.max(pick, notPick);
            }
        }

        return dp[0][0];
    }


    private int solveMem(int[] nums, int i, int prevIndex, int[][]dp){
        if(i==nums.length){
            return 0;
        }

        if(prevIndex!=-1 && dp[i][prevIndex+1]!=-1){
            return dp[i][prevIndex+1];
        }   
  
        int pick = 0, notPick = 0;
        //this cond. to make sure if the num at prev index is smaller than curr one then only we add the curr
        if(prevIndex==-1 || nums[prevIndex] < nums[i]){  
            pick = 1 + solveMem(nums, i+1, i, dp);
        }
        notPick = solveMem(nums, i+1, prevIndex, dp);

        return dp[i][prevIndex+1] = Math.max(pick, notPick);  //prevIndex+1 to prevent the -ve case
    }
}