//https://leetcode.com/problems/longest-arithmetic-subsequence/description/
package DP;
import java.util.*;

class Solution {
    public int longestArithSeqLength(int[] nums) {  
        //dp arr index stores the 'prev' index and the internal map stores the 'diff' key 
        //and ans for that 'prev' and 'diff'
        HashMap<Integer,Integer>[] dp = new HashMap[nums.length+1];

        //Memoization (TLE)
        // int ans = 0;
        
        // // Choosing 2 nums at a time
        // for(int i=0 ; i<nums.length ; i++){
        //     for(int j=i+1 ; j<nums.length ; j++){
        //         ans = Math.max(ans, 2 + solveMem(nums, j, nums[j]-nums[i], dp));
        //     }
        // }
        // return ans;


        //Tabulation
        return solveTab(nums, dp);
        
    }


    private int solveTab(int[] nums, HashMap<Integer,Integer>[] dp){
        if(nums.length<=2) return nums.length;
        
        int ans = 0;

        for(int i = nums.length-2 ; i>=0 ; i--){
            for(int j = nums.length-1 ; j>i ; j--){

                int diff = nums[i]-nums[j];

                //cnt=1, not 2 as we have added the ith element later
                int cnt=1;

                //check if ans calculated for the same diff
                if(dp[j]!=null && dp[j].containsKey(diff)){  //'prev' is j here
                    cnt = dp[j].get(diff);  //this also consists of the jth element
                }
                
                //then we assign the length of Arithmetic subseq corresponding
                if(dp[i]==null){
                    dp[i] = new HashMap<Integer,Integer>();      
                }
                dp[i].put(diff, 1+cnt);  //here we add the ith element

                ans = Math.max(ans, 1 + cnt);               
            }
        }
        return ans;
    }


    private int solveMem(int[] nums, int prev, int diff, HashMap<Integer,Integer>[] dp){
        if(prev == nums.length){
            return 0;
        }

        if(dp[prev]!=null && dp[prev].containsKey(diff)){
            return dp[prev].get(diff);
        }

        int ans=0;

        for(int i=prev+1 ; i<nums.length ; i++){
            if(nums[i]-nums[prev]==diff){
                //cannot do this like this as we need to update the prev too
                // ans++; 
                ans = Math.max(ans, 1 + solveMem(nums, i, diff, dp));
            }
        }

        if(dp[prev]==null){
            dp[prev] = new HashMap<Integer,Integer>();      
        }
        dp[prev].put(diff, ans);

        return ans;
    }
}