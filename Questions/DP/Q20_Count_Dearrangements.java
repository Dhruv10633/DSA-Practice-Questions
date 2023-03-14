//https://practice.geeksforgeeks.org/problems/dearrangement-of-balls0918/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
package Questions.DP;
import java.util.*;

class Solution{
    static long disarrange(int n){
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        
        //Memoization
        // return solveMem(n, dp);
        
        //Tabulation
        // return solveTab(n, dp);
        
        //Space Opt Tabulation
        return spaceOpt(n);
    }
    
    //Similar to Fibonacci as the nth term depends on n-1 and n-2;
    private static long spaceOpt(int n){
        if(n==1) return 0;
        if(n==2) return 1;
        
        int mod = 1000000007;
        long prev1=0, prev2=1;
        
        for(int i=3 ; i<=n ; i++){
            long ans = (((i-1) % mod) * ((prev1 + prev2) % mod)) % mod;
            
            prev1=prev2;
            prev2=ans;
        }
        return prev2;
    }
    
    private static long solveTab(int n,long dp[]){
        if(n==1) return 0;
        if(n==2) return 1;
        
        int mod = 1000000007;
        
        dp[1]=0;
        dp[2]=1;
        
        long ans=0;
        
        for(int i=3 ; i<=n ; i++){
            long temp=0;
            
            if(dp[i-1]!=-1) temp = dp[i-1] % mod;
            if(dp[i-2]!=-1) temp += dp[i-2] % mod;
            
            dp[i] = (((i-1) % mod) * (temp % mod)) % mod;
        }
        
        return dp[n];
    }
    
    private static long solveMem(int n,long dp[]){
        int mod = 1000000007;
        
        if(n==1) return 0;
        
        if(n==2) return 1;
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        /*
        (n-2) case:
        if for eg we take 0 th ball and replace with i th ball, then we can place 0 in n-1 pos. and i is at 0
        So we have fixed 2 bll pos. and are left with (n-2) balls
        
        (n-1) case:
        if for eg we take 0 th ball and place at i th pos.(doesn't replace), then we can place 0 in n-1 pos. and i can be in any (n-1) pos. too
        So we have fixed 1 bll pos. and are left with (n-1) balls (as i th ball pos is not fixed like above)
        */
        
        long ans = (((n-1)%mod) * ((solveMem(n-1,dp)%mod + solveMem(n-2, dp)%mod) % mod)) % mod;
        
        return dp[n] = ans;
    }
    
}
