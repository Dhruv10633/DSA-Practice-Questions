//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
package DP;

class Solution {

    // Not Right
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;

        int [][] dp=new int[prices.length+1][prices.length+1];

        
        int ans=0;
        for(int j=1 ; j<dp.length ; j++){

            int mx=0;
            int fmx=0;
            for(int i=1 ,k=j ; i<dp.length && k<dp.length ;i++,k++){
                dp[i][k] = Math.max( prices[k-1] - prices[i-1] , 0);

                if(i-3>=0 && k-3>=0){
                    mx+=dp[i-3][k-3];
                    dp[i][k]+=mx;
                }  
                fmx=Math.max(fmx,dp[i][k]); 
            } 
            ans=Math.max(ans,fmx);   
            
        }
        
        // int mx=0;
        // for(int i=0;i<dp.length;i++){
        //     // for(int j=0;j<dp.length;j++){
        //         mx=Math.max(dp[i][dp.length-1] ,mx);
        //     // }
        //     // System.out.println();
        // }
        
        
        return ans;
            
    }

}

