//https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
package DP;
import java.util.*;

class Solution {
    public int maxHeight(int[][] cuboids) {
        //Step 1:
        //Sort all the Cuboids in increasing order and chose the last ele as Height(we need max possible Height)
        for(int[] arr : cuboids){
            Arrays.sort(arr);
        }

        //Step 2:
        //Sort the 2D cuboids arr acc to the decreasing base width/length (we need to kep the max base cuboid below)  
        Arrays.sort(cuboids, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(b[0]!=a[0]){
                    return b[0] - a[0];
                }
                if(b[1]!=a[1]){
                    return b[1] - a[1];
                }
                return b[2] - a[2];
            }
        });

        // Step 3:
        //Now use the LIS(Longest Increasing subseq.) method (Tabular / memoization)
        // (Not Binary Search Method as we need the actual values here and it doesn't conserve the actual values just the max size of LIS)
        return solveTab(cuboids);

    }

    private int solveTab(int[][] cuboids){
        //We dont need a full 2D Dp array fro LIS(check Lis if not sure why)
        int[] curr = new int[cuboids.length+1];
        int[] prev = new int[cuboids.length+1];

        for(int i = cuboids.length-1 ; i>=0 ; i--){ //i is the curr Index
            for(int pi = i-1 ; pi>=-1 ; pi--){  //pi is the prev Index

                int pick = 0, notPick = 0;

                if(pi==-1 || (cuboids[pi][0]>=cuboids[i][0] && cuboids[pi][1]>=cuboids[i][1] && cuboids[pi][2]>=cuboids[i][2])){
                    pick = cuboids[i][2] + prev[i+1];  //[i+1] as when we pick in memoization we go to i+1, and change prev Index to i and here prev Index is starting from -ve so i+1
                    //pick = 1 + solveMem(nums, i+1, i, dp);
                }
                notPick = prev[pi+1];  //notPick = solveMem(nums, i+1, prevIndex, dp);

                curr[pi+1] = Math.max(pick, notPick);  
            }
            //copying curr to prev
            for(int j=0 ; j<curr.length ; j++){
                prev[j]=curr[j];
            }
        }

        return curr[0];
    }
}