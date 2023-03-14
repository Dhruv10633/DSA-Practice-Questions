// https://leetcode.com/problems/longest-palindromic-subsequence/description/
package DP;

class Solution {
    public int longestPalindromeSubseq(String s) {
        //We can generate all subsequences and check the longest palindrome anong them using DP but leads to (TLE)

        //Instead we take the string 's' and reverse of 's' and generate their Longest Common Subseq.(LCS)
        String s2="";
        for(int i=s.length()-1 ; i>=0 ; i--){
            s2 += s.charAt(i);
        }
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
}
