// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
package DP;

//Case V - when there is transaction fee for each
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] curr = new int[2];
        int[] prev = new int[2];
        
        for(int i=prices.length-1 ; i>=0 ; i--){
            for(int buy=0 ; buy<=1 ; buy++){

                int profit = 0;

                if(buy==1){
                    int pick = -(prices[i] + fee) + prev[0];
                    int notPick = prev[1];
                    profit = Math.max(pick, notPick);
                }
                else{
                    int pick = prices[i] + prev[1];
                    int notPick = prev[0];
                    profit = Math.max(pick, notPick);
                }
                curr[buy] = profit;
            }
            //copy
            prev[0] = curr[0];
            prev[1] = curr[1];
        }

        return curr[1];
    }
}
