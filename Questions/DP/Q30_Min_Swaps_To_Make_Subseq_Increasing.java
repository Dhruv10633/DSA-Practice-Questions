//https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/description/
package DP;

class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        // we need a 2D dp arr as if we encounter an index again ,
        // we need to check the last time we encountered it whether the last element has been swapped or not


        //Memoization:
        // int[][] dp = new int[nums1.length+1][2];
        // for(int[] arr:dp)
        //     Arrays.fill(arr, -1);
        // return solveMem(nums1 , nums2, 0, 0, dp);

        //Tabulation
        return solveTab(nums1 , nums2);
    }


    private int solveTab(int[] nums1 , int nums2[]){
        int[] curr = new int[2];
        int[] prev = new int[2];

        for(int i = nums1.length-1 ; i>=0 ; i--){
            for(int lastSwap = 1 ; lastSwap>=0 ; lastSwap--){
                int prev1 = i==0 ? -1:nums1[i-1] ;
                int prev2 = i==0 ? -1:nums2[i-1] ;
                
                //in tabulation we can't just swap the array elements like we did in recursion as we can revert back our changes there
                //so here if 'lastSwap'==1 (i.e the prev elements were swapped) we swap the prev values (as the prev index values have been swapped but we haven't done that change in the original nums arrays); 
                if(lastSwap==1){
                    int temp = prev1;
                    prev1 = prev2;
                    prev2 = temp;
                }

                int swap = Integer.MAX_VALUE, noSwap = Integer.MAX_VALUE;

                //we swap the elements if they are <= prev
                if(nums1[i] > prev2 && nums2[i] > prev1){           
                    swap = 1 + prev[1]; 
                } 
                
                if(nums1[i] > prev1 && nums2[i] > prev2)
                    noSwap = prev[0];

                curr[lastSwap] = Math.min(swap, noSwap);
            }
            //copy curr to prev
            for(int j = 0 ; j<curr.length ; j++){
                prev[j] = curr[j];
            }
        }

        return Math.min(curr[0], curr[1]);
    }


    private int solveMem(int[] nums1 , int nums2[], int i, int lastSwap, int[][] dp){
        if(i==nums1.length){
            return 0;
        }

        if(dp[i][lastSwap] != -1){
            return dp[i][lastSwap];
        }

        //the prev variable of both arr (-1 if i==0 , else nums[i-1])
        int prev1 = i==0 ? -1:nums1[i-1] ;
        int prev2 = i==0 ? -1:nums2[i-1] ;

        int swap = Integer.MAX_VALUE, noSwap = Integer.MAX_VALUE;

        //we swap the elements if they are <= prev
        if(nums1[i] > prev2 && nums2[i] > prev1){
            int temp = nums1[i];
            nums1[i] = nums2[i];
            nums2[i] = temp;
            swap = 1+solveMem(nums1, nums2, i+1, 1, dp); 
            temp = nums2[i];
            nums2[i] = nums1[i];
            nums1[i] = temp;
        } 
        
        if(nums1[i] > prev1 && nums2[i] > prev2)
            noSwap = solveMem(nums1, nums2, i+1, 0, dp);

        return dp[i][lastSwap] = Math.min(swap, noSwap);
    }
}