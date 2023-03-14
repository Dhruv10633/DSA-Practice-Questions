//https://leetcode.com/problems/reducing-dishes/solutions/3210407/java-dp-soln-all-possble-dp-methods/
package DP;
import java.util.*;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        //we sort the array so as to keep the gihest satisfaction level dishes at end
        //and low ones at start
        Arrays.sort(satisfaction);

        //dp[][], main arr here refers to time (1 - satisfaction.length)
        //internal arr here refers to the staifaction level (0 - satisfaction.length-1)
        // int[][]dp = new int[satisfaction.length+2][satisfaction.length+1];   //Not needed for Space Opt

        //Memoization
        // for(int[] arr:dp){
        //     Arrays.fill(arr, Integer.MIN_VALUE);
        // }
        // return solveMem(satisfaction, 0, 1, dp);

        //Tabulation
        // return solveTab(satisfaction, dp);

        //Space Opt (here we just need the curr internal arr we are working on along with the prev we worked on)
        return solveSpaceOpt(satisfaction);
    }


    private int solveSpaceOpt(int[] satisfaction){
        int[] curr = new int[satisfaction.length+1] , prev = new int[satisfaction.length+1];

        for(int time = satisfaction.length ; time>=1 ; time--){
            for(int i = satisfaction.length-1 ; i>=0 ; i--){
                int a = satisfaction[i] * time + prev[i+1];
                int b = curr[i+1];

                curr[i]=Math.max(a, b);
            }
            //copying prev arr to curr arr
            for(int i=0 ; i<curr.length ; i++){
                prev[i]=curr[i];
            }
        }
        return curr[0];
    } 


    private int solveTab(int[] satisfaction, int[][] dp){
        for(int time = satisfaction.length ; time>=1 ; time--){
            for(int i = satisfaction.length-1 ; i>=0 ; i--){

                int a = satisfaction[i] * time + dp[time+1][i+1];
                int b = dp[time][i+1];

                dp[time][i]=Math.max(a, b);
            }
        }

        return dp[1][0];
    } 


    private int solveMem(int[] satisfaction, int i, int time, int[][] dp){
        if(i==satisfaction.length){
            return 0;
        }

        if(dp[time][i]!=Integer.MIN_VALUE){
            return dp[time][i];
        }


        //Pick, Not pick to get all subsequnces 
        //then we find the max possible 'Like-time coefficient'
        int a = satisfaction[i] * time + solveMem(satisfaction, i+1, time+1, dp);
        int b = solveMem(satisfaction, i+1, time, dp);

        return dp[time][i]=Math.max(a, b);
    }
}
