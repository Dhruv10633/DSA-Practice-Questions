//https://leetcode.com/problems/min-cost-climbing-stairs/description/
package Questions.DP;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1) return cost[0];
        int []dp=new int[cost.length];

        //could cause probs with 0
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }

        // return Math.min(minCost(cost, 0, dp), minCost(cost, 1, dp));
        return minCostBU(cost, dp);
    }
    
    //TOP DOWN
    private int minCost(int []cost, int i, int[]dp){
        if(i>=cost.length){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int s1 = cost[i] + minCost(cost, i+1, dp);
        int s2 = cost[i] + minCost(cost, i+2, dp);
        dp[i] = Math.min(s1, s2);

        return dp[i];
    }

    //BOTTOMS UP
    private int minCostBU(int []cost, int[]dp){
        
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<dp.length;i++){
            dp[i]= cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[dp.length-1], dp[dp.length-2]);
    }
}