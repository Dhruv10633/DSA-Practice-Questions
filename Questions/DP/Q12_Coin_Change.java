//https://leetcode.com/problems/coin-change/
package DP;
import java.util.*;

class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        //Memoization
        // int ans = solveMem(coins,dp,amount);

        //Bottom(s) Up Approach :)
        int ans = solveTab(coins,dp,amount);

        if(ans!=Integer.MAX_VALUE) return ans;
        return -1;
    }

    private int solveTab(int[] coins,int[] dp, int amount){
        if(amount==0) return 0;
  
        dp[0]=0;

        for(int x=1 ; x<=amount ; x++){
            for(int am:coins){
                if(x-am >= 0 && dp[x - am] != Integer.MAX_VALUE) dp[x] = Math.min(dp[x], 1 + dp[x - am]);
            }
        }      
        return dp[amount];
    }

    private int solveMem(int[] coins,int[] dp, int amount){
        if(amount<0){
            return Integer.MAX_VALUE;
        }

        if(amount==0){
            return 0;
        }

        if(dp[amount]!=Integer.MAX_VALUE){
            return dp[amount];
        }

        int ans=Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++){
            int temp = solveMem(coins, dp, amount-coins[i]);

            //in case a soln exists / the amount must not be -ve
            //+1 because we are adding a coin 
            if(temp != Integer.MAX_VALUE) ans = Math.min(ans, 1+temp);
        }

        return dp[amount]=ans;
    }
}