//https://www.youtube.com/watch?v=xdPv2SZJLVI&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=9
//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
package DP;
// import java.util.*;

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    {
        //2D DP beacuse here 2 states are changing index and W (max weight cap.)
        
        //if we try doing it with 1D DP of W then we might know the max val at that W
        //but we wont know at which index we achieved curr W 
        
        //Vice Versa for index too
        // int [][] dp = new int[n+1][W+1];  //not needed for space opt 
        
        //Memoization
        // for(int i=0;i<=n;i++){
        //     Arrays.fill(dp[i], -1);
        // }  
        // return solveMem(wt, val, 0, W, dp);
        
        //Tabulation
        // for(int i=0;i<=n;i++){
        //     Arrays.fill(dp[i], 0);
        // } 
        // return solveTab(wt, val, W, dp);
        
        //SpaceOpt using 2 arrays instead of DP
        // return solveSpaceOpt_BETTER(wt, val, W);
        
        //SpaceOpt using 1 array instead of 2
        return solveSpaceOpt_BEST(wt, val, W);
        
    }
    
    
    private static int solveSpaceOpt_BEST(int[] wt, int[] val, int W){
        int[] curr = new int [W+1];
        
        for(int i=1 ; i<=wt.length ; i++){
            
            //here all the values are needed from the left side of the array
            //so we need to keep a track of the original left side vals , 
            //but at the same time we need to modify them too as we need to store new values 
            
            //SO we  instead our loop from the right end of arr i.e. W till 1 (val at 0 is 0)
            //Now we change the values in the curr from right to left so the left side values never change till we have reached there
            for(int w=W ; w>=1 ; w--){
                
                int inc=0,exc=0;
                
                //here we dont need [i-1] as in Tabulation below as we have the prev arr here
                if(w-wt[i-1] >= 0) inc = val[i-1] + curr[w-wt[i-1]];
                
                exc = 0 + curr[w];
                
                curr[w] = Math.max(inc,exc);
            }
        }
        
        return curr[W];
    }
    
    
    private static int solveSpaceOpt_BETTER(int[] wt, int[] val, int W){
        int[] prev = new int [W+1];
        int[] curr = new int [W+1];
        
        for(int i=1 ; i<=wt.length ; i++){
            for(int j=1 ; j<=W ; j++){
                
                int inc=0,exc=0;
                
                //here we dont need [i-1] as in Tabulation below as we have the prev arr here
                if(j-wt[i-1] >= 0) inc = val[i-1] + prev[j-wt[i-1]];
                
                exc = 0 + prev[j];
                
                curr[j] = Math.max(inc,exc);
            }
            
            //copying curr to prev
            
            for(int j=1 ; j<=W ; j++){
                prev[j]=curr[j];
            }
        }
        
        return curr[W];
    }
    
    
    private static int solveTab(int[] wt, int[] val, int W, int[][] dp){
        //Analyse the Base Case
        
        //Now Change the recursive calls to iterative ones
        for(int i=1 ; i<=wt.length ; i++){
            for(int j=1 ; j<=W ; j++){
                
                int inc=0,exc=0;
                
                //i-1 beacuse we are dealing with +1 more than the actual indexes as dp[n+1][W+1]
                
                //here if we can add this index obj without exceeding max wt we add
                if(j-wt[i-1] >= 0) inc = val[i-1] + dp[i-1][j-wt[i-1]];
                
                exc = 0 + dp[i-1][j];
                
                dp[i][j] = Math.max(inc,exc);
            }
        }
        
        return dp[wt.length][W]; 
    }
    
    
    private static int solveMem(int[] wt, int[] val, int i, int W, int[][] dp){
        if(i==wt.length){
            return 0;
        }
        
        if(dp[i][W]!=-1){
            return dp[i][W];
        }
        
        int inc=0,exc=0;
        
        //here we use the the concet of either takingthe ith index ele or leaving it
        //this helps to get us all subsequences possible for array (if we remove the 1st condition)(eg. all subsequences of string)
        if(W-wt[i] >=0) inc = val[i] + solveMem(wt, val, i+1, W-wt[i], dp);
        exc = 0 + solveMem(wt, val, i+1, W, dp);
        
        return dp[i][W] = Math.max(inc,exc);
    }
}