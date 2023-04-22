// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
package DP;
import java.util.*;

class Solution {
    public int minInsertions(String s) {
        //String length - Length of Longest Palindromic subseq is the ans
        //because if we have the longest Palindromic subseq length then the char wee need to insert/delete to make the entire string palindromic is (String length - Length of Longest Palindromic subseq)

        //Memoization;
        StringBuilder rev = new StringBuilder();
        for(int i=s.length()-1 ; i>=0 ; i--){
            rev.append(s.charAt(i));
        }

        int[][] dp = new int[s.length()+1][rev.length()+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return s.length() - solveMem(s, rev, 0, 0, dp) ;
    }


    private int solveMem(String s1, StringBuilder s2, int i, int j, int[][] dp){
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
