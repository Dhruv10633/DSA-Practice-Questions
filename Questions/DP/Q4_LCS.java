// https://leetcode.com/problems/longest-common-subsequence/description/
package DP;

class Solution {
    public int longestPalindromeSubseq(String s) {
        //We can generate all subsequences and check the longest palindrome anong them using DP but leads to (TLE)

        //Instead we take the string 's' and reverse of 's' and generate their Longest Common Subseq.(LCS)
        String s2="";
        for(int i=s.length()-1 ; i>=0 ; i--){
            s2 += s.charAt(i);
        }

        int[][] dp = new int[s.length()+1][s2.length()+1];

        //Memoization
        // for(int[] arr : dp){
        //     Arrays.fill(arr, -1);
        // }
        // return solveMem(s, s2, 0, 0, dp);

        //Tabulation
        // return solveTab(s, s2, dp);

        //Space Opt
        return solveSpaceOpt(s, s2);
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


    private int solveTab(String s1, String s2, int[][] dp){
        for(int i=s1.length()-1 ; i>=0 ; i--){
            for(int j=s2.length()-1 ; j>=0 ; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }


    private int solveMem(String s1, String s2, int i, int j, int[][] dp){
        if(i>=s1.length() || j>=s2.length()){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + solveMem(s1, s2, i+1, j+1, dp);
        }
        else{
            return dp[i][j] = Math.max(solveMem(s1, s2, i+1, j, dp), solveMem(s1, s2, i, j+1, dp));
        }
    }
}