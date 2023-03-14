//https://leetcode.com/problems/minimum-sideway-jumps/solutions/3210104/simple-java-soln-all-approaches/
package DP;

class Solution {
    public int minSideJumps(int[] obstacles) {
        // int[][] dp = new int[4][obstacles.length+1];   //Not needed for space opt

        //Memoization 
        // for(int arr[]: dp){
        //     Arrays.fill(arr,Integer.MAX_VALUE);
        // }
        // return solveMem(obstacles, 2, 0, dp);

        //Tabulation
        // return solveTab(obstacles, dp);

        //Space Opt (we just need two arrays actually one to store the dat we working on RN. and the other to store the prev data)
        return solveSpaceOpt(obstacles);
    }


    private int solveSpaceOpt(int[] obstacles){
        int[] curr = new int[4], prev = new int[4];

        for(int i = obstacles.length-2 ; i>=0 ; i--){
            for(int path = 3 ; path>=1 ; path--){
                int minSS = Integer.MAX_VALUE;

                if(obstacles[i+1]!=path){
                    minSS = prev[path];
                }

                else{
                    if(path-2==1 && obstacles[i]!=path-2){
                        minSS = 1 + prev[path-2];
                    }
                    if(path+2==3 && obstacles[i]!=path+2){
                        minSS = Math.min(minSS, 1 + prev[path+2]);
                    }
                    if(path-1>=1 && obstacles[i]!=path-1){
                        minSS = Math.min(minSS, 1 + prev[path-1]);
                    }
                    if(path+1<=3 && obstacles[i]!=path+1){
                        minSS = Math.min(minSS, 1 + prev[path+1]);
                    }
                }
                curr[path]=minSS;
            }
            //copyint the curr row to the prev row
            for(int j=0 ; j<curr.length ; j++){
                prev[j]=curr[j];
            }
        }
        return curr[2];
    }


    private int solveTab(int[] obstacles, int[][] dp){
        for(int i = obstacles.length-2 ; i>=0 ; i--){
            for(int path = 3 ; path>=1 ; path--){
                int minSS = Integer.MAX_VALUE;

                if(obstacles[i+1]!=path){
                    minSS = dp[path][i+1];
                }

                //in Memoization we haven't done +1 to 'i' for else case
                //but here we need to do +1  as we will need to check for the next col in dp

                else{
                    if(path-2==1 && obstacles[i]!=path-2){
                        minSS = 1 + dp[path-2][i+1];
                    }
                    if(path+2==3 && obstacles[i]!=path+2){
                        minSS = Math.min(minSS, 1 + dp[path+2][i+1]);
                    }
                    if(path-1>=1 && obstacles[i]!=path-1){
                        minSS = Math.min(minSS, 1 + dp[path-1][i+1]);
                    }
                    if(path+1<=3 && obstacles[i]!=path+1){
                        minSS = Math.min(minSS, 1 + dp[path+1][i+1]);
                    }
                }
                dp[path][i]=minSS;
            }
        }
        return dp[2][0];
    }


    private int solveMem(int[] obstacles, int path, int i, int[][] dp){
        if(i==obstacles.length-1){
            return 0;
        }

        if(dp[path][i]!=Integer.MAX_VALUE){
            return dp[path][i];
        }

        int minSS = Integer.MAX_VALUE;

        //if there is no obstacle in path we move frwd
        if(obstacles[i+1]!=path){
            minSS = solveMem(obstacles, path, i+1, dp);
        }
        else{
            //for the 3rd path only(jumping 2 paths up)
            if(path-2==1 && obstacles[i]!=path-2){
                minSS = 1 + solveMem(obstacles, path-2, i, dp);
            }

            //for the 1st part only(jumping 2 paths down)
            if(path+2==3 && obstacles[i]!=path+2){
                minSS = Math.min(minSS, 1 + solveMem(obstacles, path+2, i, dp));
            }

            //for all paths
            if(path-1>=1 && obstacles[i]!=path-1){
                minSS = Math.min(minSS, 1 + solveMem(obstacles, path-1, i, dp));
            }
            if(path+1<=3 && obstacles[i]!=path+1){
                minSS = Math.min(minSS, 1 + solveMem(obstacles, path+1, i, dp));
            }
        }
        return dp[path][i] = minSS;
    }
}