// https://leetcode.com/problems/restore-the-array/description/
package DP;
import java.util.*;

class Solution {

    private int mod = (int)1e9+7;
    
    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);

        return solveMem(s, k, 0, dp);
    }


    private int solveMem(String s, int k, int i, int[] dp){
        if(i==s.length()) return 1;

        if(dp[i]!=-1) return dp[i];

        long num=0; int ans=0;

        for(int x=i; x<s.length() ;x++){
            num = num*10 + s.charAt(x)-'0';

            if(num==0 || num>k){
                return dp[i] = ans;
            }
            else ans = (ans + solveMem(s, k, x+1, dp)) % mod;

        }
        return dp[i] = ans;
    }
}
