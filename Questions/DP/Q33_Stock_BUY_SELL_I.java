//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
package DP;

//Type 1 : Single Day buy sell
class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int profit=0;

        for(int i=1;i<prices.length;i++){
            if(prices[i] > buy){
                profit = Math.max(profit, prices[i] - buy);
            }
            else{
                buy = Math.min(buy, prices[i]);
            }
        }
        return profit;
    }
}
