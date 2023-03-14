//https://leetcode.com/problems/perfect-squares/description/
package Questions.DP;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];

        //Memoization
        // return solveMem(n, dp);

        //Tabulation
        return solveTab(n, dp);

        //No Space Optimisation as further dependency can't be broken
    }


    private int solveTab(int n, int[] dp){
        dp[1]=1;

        for(int i=2;i<=n;i++){

            int ans = Integer.MAX_VALUE;
            for(int sq = (int)Math.sqrt(i) ; sq>=1 ; sq--){
                if(sq*sq==i) {
                    ans=1;
                    break;
                }
                if(i-sq*sq >= 1) ans = Math.min(ans, 1 + dp[i-sq*sq]);
            }
            dp[i]=ans;
        }
        return dp[n];
    }


    private int solveMem(int n, int[] dp){
        if(n==1){
            return 1;
        }

        if(dp[n]!=0) return dp[n];

        int ans = Integer.MAX_VALUE;
        for(int sq = (int)Math.sqrt(n) ; sq>=1 ; sq--){
            if(sq*sq==n) return 1;
            else ans = Math.min(ans, 1 + solveMem(n-sq*sq, dp));
        }
        return dp[n]=ans;
    }
}