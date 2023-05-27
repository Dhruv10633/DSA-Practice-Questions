// https://leetcode.com/problems/stone-game-ii/
package DP;

class Solution {
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[piles.length+1][piles.length+1][2];
        return solveMem(piles, 0, 1, 0, dp);
    }

    private int solveMem(int[] piles, int i, int m, int turn, int[][][] dp){
        if(i == piles.length) return 0;

        int temp_amnt = 0, ans = turn==0 ? 0 : Integer.MAX_VALUE;
        for(int x = 1; x <= 2*m; x++){
            int pi = i + x - 1;

            if(dp[i][m][turn]!=0){
                return dp[i][m][turn];
            }

            if(pi >= piles.length) break;

            temp_amnt += piles[pi];

            if(turn==0){
                ans = Math.max(ans, temp_amnt + solveMem(piles, pi+1, Math.max(m, x), 1, dp));
            }
            else{
                ans = Math.min(ans, solveMem(piles, pi+1, Math.max(m, x), 0, dp));
            }
        }

        return dp[i][m][turn] = ans;
    }
}
