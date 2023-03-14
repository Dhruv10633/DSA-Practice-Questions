//https://leetcode.com/problems/minimum-score-triangulation-of-polygon/description/

class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length+1][values.length+1];

        //Memoization
        // return solveMem(values, 0 , values.length-1, dp);

        //Tabulation
        return solveTab(values, dp);

        //Space Opt. is not possible as the final ans dp[i][j] depends on dp[i][k] && dp[k][j] ,
        //and and all these are differnt and we need a N*N matrix for that
    }

    //Reverse the Top down
    //Here we start 'i' from 'values.length-1' and 'j' from i+2 (as we need the at least 3 coord to make a triangle)
    private int solveTab(int[] values, int[][] dp){

        for(int i = values.length-1 ; i>=0 ; i-- ){
            for(int j = i+2 ; j<values.length ; j++){
                int minScore = Integer.MAX_VALUE;

                for(int k=i+1 ; k<j ; k++){
                    int currScore = dp[i][k];
                    currScore += dp[k][j];
                    currScore += values[i]*values[j]*values[k];

                    minScore = Math.min(minScore, currScore);
                }
                dp[i][j] = minScore;
            }
        }

        return dp[0][values.length-1];
    }


    //Here we take the edge connecting 'i' and 'j' to be the base for the triangle
    //then we select any point 'k' between 'i' and 'j' then create a triangle and
    //Then divide the prob. in to 2 sub probs. one where new base is edge btw. 'i' and 'k' , in other it is btw. 'k' and 'j' 
    private int solveMem(int[] values, int i, int j, int[][] dp){
        if(i+1==j || i==j){
            return 0;
        }

        if(dp[i][j]!=0){
            return dp[i][j];
        }

        int minScore = Integer.MAX_VALUE;

        for(int k=i+1 ; k<j ; k++){

            int currScore = solveMem(values, i, k, dp);
            currScore += solveMem(values, k, j, dp);
            currScore += values[i]*values[j]*values[k];

            minScore = Math.min(minScore, currScore);
        }

        return dp[i][j] = minScore;
    }
}
