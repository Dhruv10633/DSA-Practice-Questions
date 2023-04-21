// https://leetcode.com/problems/profitable-schemes/
package DP;
import java.util.*;

class Solution {

    private int mod = (int)1e9 + 7;

    public int profitableSchemes(int n, int minProf, int[] group, int[] profit) {
        int[][][] dp = new int[group.length+1][n+1][minProf+1];
        
        for(int[][] temp1 : dp){
            for(int[] temp2 : temp1){
                Arrays.fill(temp2, -1);
            }
        }
        return solveMem(n, minProf, group, profit, 0, dp) ;
    }


    private int solveMem(int n, int minProf, int[] group, int[] profit, int i, int[][][] dp) {
        if (n < 0) return 0;

        if ((i >= group.length)) {
            if (minProf <= 0 && n >= 0) return 1;
            return 0;
        }

        minProf = Math.max(0,minProf);

        if(dp[i][n][minProf]!=-1){
            return dp[i][n][minProf];
        }

        int ans = 0;

        // Pick
        ans += solveMem(n - group[i], minProf - profit[i], group, profit, i + 1, dp) % mod;

        // Not pick
        ans += solveMem(n, minProf, group, profit, i + 1, dp) % mod;

        return dp[i][n][minProf] = ans % mod;
    }
}