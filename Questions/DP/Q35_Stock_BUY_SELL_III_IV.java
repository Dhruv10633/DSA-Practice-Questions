// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
package DP;

// TYPE IV is same as III just instead of 2 trans. limit just there is k trans. limit
class Solution {
    public int maxProfit(int[] prices) {
        // int[][][] dp = new int[prices.length+1][2][3];  // only for tabulation and memoization

        //Memoization
        // for(int[][] arr : dp){
        //     for(int[] temp: arr){
        //         Arrays.fill(temp ,-1);
        //     }
        // }
        // return solveMem(prices, 0, 1, 2, dp);

        //Tabulation
        // return solveTab(prices, dp);

        //Space Optimized
        return spaceOpt(prices);
    }


    private int spaceOpt(int[] prices){
        int[][] curr = new int[2][3];
        int[][] prev = new int[2][3];

        for(int i = prices.length-1; i>=0 ; i--){
            for(int buy = 0 ; buy<=1 ; buy++){
                for(int limit = 1 ; limit<=2 ; limit++){
                    int profit = 0;

                    if(buy==1){
                        int pick = prev[0][limit] - prices[i];
                        int notPick = 0 + prev[1][limit];
                        profit = Math.max(pick, notPick);
                    }
                    else{
                        //+prices[i] as the profit = +sell - buy
                        int pick = prices[i] + prev[1][limit-1]; 
                        int notPick = 0 + prev[0][limit];
                        profit = Math.max(pick, notPick);
                    }

                    curr[buy][limit] = profit;
                }
            }
            //copy curr to prev;
            for(int j=0;j<curr.length;j++){
                for(int k=0;k<curr[0].length;k++){
                    prev[j][k]=curr[j][k];
                }
            }
        }
        return curr[1][2];
    }


    private int solveTab(int[] prices, int[][][] dp){
        for(int i = prices.length-1; i>=0 ; i--){
            for(int buy = 0 ; buy<=1 ; buy++){
                for(int limit = 1 ; limit<=2 ; limit++){
                    int profit = 0;

                    if(buy==1){
                        int pick = -prices[i] + dp[i+1][0][limit];
                        int notPick = 0 + dp[i+1][1][limit];
                        profit = Math.max(pick, notPick);
                    }
                    else{
                        //+prices[i] as the profit = +sell - buy
                        int pick = prices[i] + dp[i+1][1][limit-1]; 
                        int notPick = 0 + dp[i+1][0][limit];
                        profit = Math.max(pick, notPick);
                    }

                    dp[i][buy][limit] = profit;
                }
            }
        }

        return dp[0][1][2];
    }


    private int solveMem(int[] prices, int i, int buy, int limit, int[][][] dp){
        if(i==prices.length || limit==0){
            return 0;
        }

        if(dp[i][buy][limit]!=-1){
            return dp[i][buy][limit];
        }

        int profit = 0;

        if(buy==1){
            //-prices[i] as the profit = sell - buy
            //no change in limit as 1 transaction = 1 buy + 1 sell
            int pick = -prices[i] + solveMem(prices, i+1, 0, limit, dp); // buy==0 means u have bought nowneed to sell
            int notPick = 0 + solveMem(prices, i+1, 1, limit, dp);  // buy==1 means has not bought now but can buy some other day
            profit = Math.max(pick, notPick);
        }
        else{
            //+prices[i] as the profit = +sell - buy
            int pick = prices[i] + solveMem(prices, i+1, 1, limit-1, dp); 
            int notPick = 0 + solveMem(prices, i+1, 0, limit, dp);
            profit = Math.max(pick, notPick);
        }

        return dp[i][buy][limit] = profit;
    }
}