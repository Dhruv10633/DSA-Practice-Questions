//https://leetcode.com/problems/maximal-square/description/

import java.util.*;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int[] ans = new int[1];

        //Needed for Tabulation and Memoization
        // int dp[][] = new int[matrix.length+1][matrix[0].length+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }

        //Memoiztion
        // solveMem(matrix, 0 , 0, ans, dp);

        //Tabulation
        // solveTab(matrix, ans, dp);

        //Space Optimized 
        solveSpaceOpt(matrix, ans);

        return ans[0];
    }


    private void solveSpaceOpt(char[][] matrix, int[] ans){
        //Since in the tabulation method we nee just the ele at pos: 
        //just ahead, diagnol, and just below 
        //this can be done by taking our loop from the bottom right of the matrix and going up and taking 2 arrays : curr and prev
        
        //curr - current arr on which we are working from rt to left and thus can check just right value
        //prev - the below array for check diagnol and right below value
        int[] curr = new int[matrix[0].length+1];
        int[] prev = new int[matrix[0].length+1];

        for(int i=matrix.length-1 ; i>=0 ; i--){
            for(int j=matrix[0].length-1 ; j>=0 ; j--){

                int right=0, diagnol=0, down=0;
                if(curr[j+1]!=-1) right = curr[j+1];
                if(prev[j+1]!=-1) diagnol = prev[j+1];
                if(prev[j]!=-1) down = prev[j];

                if(matrix[i][j]=='1'){
                    int temp = 1 + Math.min(right, Math.min(diagnol, down));
                    ans[0] = Math.max(ans[0], temp*temp);

                    curr[j] = temp;
                }
                else{
                    curr[j] = 0;
                }
            }

            //copying curr to pre
            for(int j=0;j<curr.length;j++){
                prev[j]=curr[j];
            }
        }
    }

    
    private void solveTab(char[][] matrix, int[] ans, int[][] dp){
        dp[matrix.length][matrix[0].length]=0;

        for(int i=matrix.length-1 ; i>=0 ; i--){
            for(int j=matrix[0].length-1 ; j>=0 ; j--){

                int right=0, diagnol=0, down=0;
                if(dp[i][j+1]!=-1) right = dp[i][j+1];
                if(dp[i+1][j+1]!=-1) diagnol = dp[i+1][j+1];
                if(dp[i+1][j]!=-1) down = dp[i+1][j];

                if(matrix[i][j]=='1'){
                    int temp = 1 + Math.min(right, Math.min(diagnol, down));
                    ans[0] = Math.max(ans[0], temp*temp);

                    dp[i][j] = temp;
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
    }


    private int solveMem(char[][] matrix, int i, int j, int[] ans, int[][] dp){
        if(i>=matrix.length || j>=matrix[0].length){
            return 0; 
        }

        //check if we have already calculated for this vertex before
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        // we start from (0,0) and expand in all 3 directions
        //At each cordinate we check is we can expand further
        int right = solveMem(matrix, i, j+1, ans, dp);
        int diagnol = solveMem(matrix, i+1, j+1, ans, dp);
        int down = solveMem(matrix, i+1, j, ans, dp);

        if(matrix[i][j]=='1'){
            //min of all the 3 lengths we can find in all 3 directions
            int temp = 1 + Math.min(right, Math.min(diagnol, down));
            //temp is the max length of the side of the sqr.
            ans[0] = Math.max(ans[0], temp*temp);

            return dp[i][j] = temp;
        }
        else{
            return dp[i][j]=0;
        }
        //write the '0' cond here not at the start so that even in case of 0 we check forward for all possible points
        //On writing it before the recurs. cond. it wont check further and stop the search ahead
    }
}