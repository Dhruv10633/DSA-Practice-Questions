//Optimal Strategy for a Game
//https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
//the players can take coin from either end or start
import java.util.*;


class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        long[][] dp = new long[n+1][n+1];
        
        for(long[] x : dp){
            Arrays.fill(x, -1);
        }
        
        return solveMem(arr, 0, n-1, dp);
    }
    
    static long solveMem(int[]arr, int i,int n, long[][] dp){
        if(i>=n){
            return 0;
        }
        
        if(dp[i][n]!=-1) return dp[i][n];
        
        long t1 = arr[i] + Math.min(solveMem(arr, i+2, n, dp), solveMem(arr, i+1, n-1, dp));
        long t2 = arr[n] + Math.min(solveMem(arr, i+1, n-1, dp), solveMem(arr, i, n-2, dp));
        
        return dp[i][n] = Math.max(t1,t2);
    }
}
                                         
