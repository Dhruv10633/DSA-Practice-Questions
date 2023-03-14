//https://leetcode.com/problems/coin-change-ii/description/
package DP;

class Solution {

    //Pick AND Not Pick
    
    public int change(int amount, int[] coins) {
        // Arrays.sort(coins);
        int [][] dp=new int[amount + 1][coins.length + 1];
        for(int i=0;i<=amount;i++){
            for(int j=0;j<=coins.length;j++){
                dp[i][j]=-1;
            }
        }

        //TOP DOWN
        // return totalWaysTD(amount, 1, coins, dp);  // i=1 stores val of coin 0

        //BOTTOM UP
        return totalWaysBU(amount, coins, dp);
    }

    //TOP DOWN
    private int totalWaysTD(int amount, int i, int[] coins, int[][] dp){
        if(amount==0){
            return 1;
        }
        if(i>=coins.length+1){
            return 0;
        }
        
        if(dp[amount][i] != -1){
            return dp[amount][i];
        }

        int inc=0, exc=0;

        //keep subteacting that coin val
        if(amount >= coins[i-1]){
            inc = totalWaysTD(amount - coins[i-1], i, coins, dp);
        }
        //excluding that coin
        exc = totalWaysTD(amount, i+1, coins, dp);

        dp[amount][i] = inc+exc;

        return dp[amount][i] = inc+exc;
    }

    //BOTTOM UP
    private int totalWaysBU(int amount, int[] coins, int[][] dp){

        for(int i=0 ; i<=amount ; i++){
            for(int j=0 ; j<=coins.length ; j++){
                if(i==0){
                    dp[i][j]=1;
                }
                else if(j==0){
                    dp[i][j]=0;
                }
                // System.out.print(dp[i][j]+" ");
            }
            // System.out.println();
        }


        for(int i=1 ; i<=amount ; i++){

            for(int j=1 ; j<=coins.length ; j++){
                int inc=0, exc=0;
                //Amount >= ..
                if(i >= coins[j-1]){
                    inc =  dp[i-coins[j-1]][j];
                }
                //if amount< we add the possible ways till the prev coin
                exc = dp[i][j-1];
                dp[i][j]=inc+exc;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    //BRUTEFORCE
    // private int totalWays(int amount, int i, int[] coins){
    //     int count=0;
    //     if(amount<0){
    //         return count;
    //     }
    //     if(amount==0){
    //         return 1;
    //     }

    //     for(int j=i;j<coins.length;j++){
    //         if(coins[j] <= amount){
    //             count += totalWays(amount - coins[j], j, coins);
    //         }
            
    //     }
    //     return count;
    // }
}
