//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
package DP;

// Type 2 : buy and sell multiple days for max profit
class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;

        int b=0;

        for(int i=0;i<prices.length;i++){
            if(prices[b]>prices[i]){
                b=i;
            }
            if(prices[i]>prices[b]){
                profit += prices[i]-prices[b];
                b=i;
            }
        }

        return profit;
    }
}