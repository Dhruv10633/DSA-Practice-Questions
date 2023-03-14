// https://leetcode.com/problems/longest-common-subsequence/description/
package DP;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //Memoization
        // int[][] dp = new int[text1.length()+1][text2.length()+1];
        // for(int[] arr: dp){
        //     Arrays.fill(arr,-1);
        // }
        // return solveMem(text1, text2, 0, 0, dp);

        //Space Opt
        return solveSpaceOpt(text1, text2);
    }


    private int solveSpaceOpt(String text1, String text2){
        int[] curr = new int[text2.length()+1];
        int[] prev = new int[text2.length()+1];

        for(int i=text1.length()-1 ; i>=0 ; i--){
            for(int j=text2.length()-1 ; j>=0 ; j--){
                int maxLen = 0;
                if(text1.charAt(i)==text2.charAt(j)){
                    maxLen = 1 + prev[j+1];
                }
                else{
                    maxLen = Math.max(prev[j], curr[j+1]);
                }

                curr[j] = maxLen;
            }
            //copy
            for(int j=0;j<curr.length;j++){
                prev[j]=curr[j];
            }
        }

        return curr[0];
    }

    
    private int solveMem(String text1, String text2, int i, int j, int[][]dp){
        if(i==text1.length() || j==text2.length()){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int maxLen = 0;
        if(text1.charAt(i)==text2.charAt(j)){
            maxLen = 1 + solveMem(text1, text2, i+1, j+1, dp);
        }
        else{
            maxLen = Math.max(solveMem(text1, text2, i+1, j, dp), solveMem(text1, text2, i, j+1, dp));
        }

        return dp[i][j] = maxLen;
    }
}