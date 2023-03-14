//https://leetcode.com/problems/edit-distance/solutions/
package DP;

class Solution {
    public int minDistance(String word1, String word2) {
        // int[][] dp =new int[word1.length()+1][word2.length()+1];  //for Memoization and Tabulation

        //Memoization
        // for(int[] arr:dp){
        //     Arrays.fill(arr, -1);
        // }
        // return solveMem(word1, word2, 0, 0, dp);

        //Tabulation
        // return solveTab(word1, word2, dp);

        //Space Opt
        return solveSpaceOpt(word1, word2);
    }


    private int solveSpaceOpt(String word1, String word2){
        //We need these cond. to pass the edgecases
        if(word1.length()==0) return word2.length();
        if(word2.length()==0) return word1.length();

        int[] curr = new int[word2.length()+1];
        int[] prev = new int[word2.length()+1];

        //Analyze the Memoization Base cases
        for(int j=0 ; j<=word2.length() ; j++){
            prev[j] = word2.length()-j;        
        }

        for(int i=word1.length()-1 ; i>=0 ; i--){
            
            //Analyze the Memoization Base cases
            curr[word2.length()] = word1.length()-i;

            for(int j=word2.length()-1 ; j>=0 ; j--){
                
                int minSteps;

                if(word1.charAt(i)==word2.charAt(j)){
                    minSteps = prev[j+1];
                }
                else{               
                    int replace = 1 + prev[j+1];
                    int delete = 1 + prev[j];
                    int insert = 1 + curr[j+1];

                    minSteps = Math.min(replace, Math.min(delete, insert));
                }

                curr[j] = minSteps;
            }
            //copy
            for(int j=0;j<curr.length;j++){
                prev[j]=curr[j];
            }
        }

        return curr[0];
    }


    private int solveTab(String word1, String word2, int[][] dp){

        //Analyze the Memoization Base cases
        for(int i=0 ; i<=word1.length() ; i++){
            dp[i][word2.length()]= word1.length()-i;
        }
        for(int j=0 ; j<=word2.length() ; j++){
            dp[word1.length()][j] = word2.length()-j;
        }


        for(int i=word1.length()-1 ; i>=0 ; i--){
            for(int j=word2.length()-1 ; j>=0 ; j--){
                
                int minSteps;

                if(word1.charAt(i)==word2.charAt(j)){
                    minSteps = dp[i+1][j+1];
                }
                else{               
                    int replace = 1 + dp[i+1][j+1];
                    int delete = 1 + dp[i+1][j];
                    int insert = 1 + dp[i][j+1];

                    minSteps = Math.min(replace, Math.min(delete, insert));
                }

                dp[i][j] = minSteps;
            }
        }

        return dp[0][0];
    }


    private int solveMem(String word1, String word2, int i, int j, int[][] dp){
        if(i==word1.length() || j==word2.length()){
            return (word1.length()-i) + (word2.length()-j);
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int minSteps;

        //if char at both pos equal we just move ahead
        if(word1.charAt(i)==word2.charAt(j)){
            minSteps = solveMem(word1, word2, i+1, j+1, dp);
        }
        else{
            //since after replacing ith char with j's onecharAt(i)==charAt(j) so both move ahead
            int replace = 1 + solveMem(word1, word2, i+1, j+1, dp);
            //we delete the unmatching ith element but j is still there unmatched
            int delete = 1 + solveMem(word1, word2, i+1, j, dp);
            //we have added the jth element at the ith pos so i is still there but we move j ahead(as it has been made to match) 
            int insert = 1 + solveMem(word1, word2, i, j+1, dp);

            minSteps = Math.min(replace, Math.min(delete, insert));
        }

        return dp[i][j] = minSteps;
    }
}
