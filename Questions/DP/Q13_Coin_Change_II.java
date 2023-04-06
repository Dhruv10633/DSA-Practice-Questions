//https://leetcode.com/problems/coin-change-ii/description/
package DP;
import java.util.*;

class Solution {

    //Pick AND Not Pick
    
    public int change(int amount, int[] coins) {
        // Arrays.sort(coins);
        int [][] dp=new int[amount + 1][coins.length + 1];

        //TOP DOWN
        for(int i=0;i<=amount;i++){
            for(int j=0;j<=coins.length;j++){
                dp[i][j]=-1;
            }
        }
        return totalWays(amount, 0, coins, dp);
        
        //BOTTOM UP
        // return totalWaysBU(coins, dp);


    }

    private int totalWaysBU(int[] coins, int[][] dp){
        Arrays.fill(dp[0],1);

        for(int amount = 1 ; amount< dp.length ; amount++){
            for(int i=0 ; i<coins.length ; i++){
                int count=0;
                for(int j=i;j<coins.length;j++){
                    if(coins[j] <= amount){
                        count += dp[amount-coins[j]][j];
                    }    
                }
                dp[amount][i]=count;
            }
        }

        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        return dp[dp.length-1][0];
    }


   
    private int totalWays(int amount, int i, int[] coins, int[][]dp){
        int count=0;
        if(amount<0){
            return 0;
        }
        if(amount==0){
            return 1;
        }

        if(dp[amount][i]!=-1){
            return dp[amount][i];
        }

        for(int j=i;j<coins.length;j++){
            if(dp[amount][j]!=-1){
                count += dp[amount][j];
                break;
            }
            else if(coins[j] <= amount){
                count += totalWays(amount - coins[j], j, coins, dp);
            }
            
        }
        return dp[amount][i]=count;
    }


}