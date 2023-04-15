// https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/description/
package DP;
import java.util.*;

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size()+1][k+1];

        //Memoization
        // for(int[] x : dp){
        //     Arrays.fill(x, -1);
        // }
        // return solveMem(piles, 0, k, dp);

        // Tabulation
        return solveTab(piles, k, dp);
    }


    private int solveTab(List<List<Integer>> piles, int k, int[][] dp){
        for(int i=piles.size()-1 ; i>=0 ; i--){

            for(int j=1 ; j<=k ; j++){
                //Not pick
                int val1 = dp[i+1][j];


                List<Integer> temp = piles.get(i);
                int val2 = 0, currVal = 0, maxCoins = j;

                for(int x=0 ; x<temp.size() && maxCoins>0 ; x++){          
                    //Pick
                    currVal += temp.get(x);
                    val2 = Math.max(val2, currVal + dp[i+1][maxCoins-1]);
                    maxCoins--;
                }

                dp[i][j] = Math.max(val1, val2);
            }
        }

        return dp[0][k];
    }


    private int solveMem(List<List<Integer>> piles, int i, int k, int[][] dp){
        if(k==0 || i==piles.size()){
            return 0;
        }

        if(dp[i][k] != -1){
            return dp[i][k];
        }

        //Not pick
        int val1 = solveMem(piles, i+1, k, dp);


        List<Integer> temp = piles.get(i);
        int val2 = 0, currVal = 0, maxCoins = k;

        for(int x=0 ; x<temp.size() && maxCoins>0 ; x++){          
            //Pick
            currVal += temp.get(x);
            val2 = Math.max(val2, currVal + solveMem(piles, i+1, maxCoins-1, dp));
            maxCoins--;
        }

        return dp[i][k] = Math.max(val1, val2);
    }
}
