// https://leetcode.com/problems/climbing-stairs/description/
// https://www.youtube.com/watch?v=Y0lT9Fck7qI
package Questions.DP;

class Solution {
    
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int dp[]=new int[n+1];

        //could cause probs with 0
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }

        //TD
        // return totalTD(n, dp);

        //BU
        return totalBU(n, dp);
    }

    //Top Down
    private int totalTD(int n,int[] dp){
        int count=0;
        if(n<0){
            return 0;
        }
        if(n<=1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }

        dp[n] = totalTD(n-1,dp) + totalTD(n-2,dp);
        return dp[n];
    }

    //Bottom UP
    private int totalBU(int n,int[] dp){
        dp[n-1]=1;
        dp[n-2]=2;

        for(int i=n-3 ; i>=0 ; i--){
            dp[i]=dp[i+1]+dp[i+2];
        }

        return dp[0];
        
    }
}

