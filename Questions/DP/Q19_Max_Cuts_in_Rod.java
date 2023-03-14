//https://practice.geeksforgeeks.org/problems/cutted-segments1642/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
package Questions.DP;
import java.util.*;

class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        
        //Memoization
        // int ans = solveMem(n,x,y,z,dp);
        
        //Tabulation
        int ans = solveTab(n,x,y,z,dp);
        
        if(ans > 0) return ans;
        return 0;
    }
    
    private int solveTab(int n, int x, int y, int z, int[] dp){
        int min = Integer.MIN_VALUE;
        dp[0]=0;
        
        for(int len=1 ; len<=n ; len++){
            
            int temp = len-x;
            if(temp>=0 && dp[temp]!=min) dp[len] = Math.max(dp[len], 1+dp[temp]);  //dp[temp] = cuts till n-x length
            
            temp = len-y;
            if(temp>=0 && dp[temp]!=min) dp[len] = Math.max(dp[len], 1+dp[temp]);
            
            temp = len-z;
            if(temp>=0 && dp[temp]!=min) dp[len] = Math.max(dp[len], 1+dp[temp]);
        }
        
        return dp[n];
    }
    
    private int solveMem(int n, int x, int y, int z, int[] dp){
        int min = Integer.MIN_VALUE;
        
        if(n<0){
            return min;
        }
        if(n==0){
            return 0;
        }
        
        if(dp[n]!=min){
            return dp[n];
        }
        
        int maxCuts=min;
        
        //in case we have a 'min' val return from the func. calls below we ignore them
        //as that means there is no soln
        
        ////+1 to add current cut
        
        int temp = solveMem(n-x,x,y,z,dp);
        if(temp!=min) maxCuts = Math.max(maxCuts, 1+temp);
        
        temp = solveMem(n-y,x,y,z,dp);
        if(temp!=min) maxCuts = Math.max(maxCuts, 1+temp);
        
        temp = solveMem(n-z,x,y,z,dp);
        if(temp!=min) maxCuts = Math.max(maxCuts, 1+temp);

        /*
        U can do this in case of small test cases

        maxCuts = Math.max(maxCuts, 1+solveMem(n-x,x,y,z,dp));
        maxCuts = Math.max(maxCuts, 1+solveMem(n-y,x,y,z,dp));
        maxCuts = Math.max(maxCuts, 1+solveMem(n-z,x,y,z,dp));
         */
        
        return dp[n] = maxCuts;
    }
}
