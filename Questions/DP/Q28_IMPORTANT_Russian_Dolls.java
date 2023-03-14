//https://leetcode.com/problems/russian-doll-envelopes/description/
package DP;
import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //if widths are equal then we sort the heights in decreasing order
        //else we sort the widths in increasing order

        // https://leetcode.com/problems/russian-doll-envelopes/solutions/2071477/c-java-python-best-explanation-with-pictures/

        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0]==arr2[0]){
                    return arr2[1]-arr1[1];
                }
                else return arr1[0]-arr2[0];
            }
        });
        

        // int[] dp = new int[envelopes.length+1];  // for memoization and Tabulation

        //Memoization  (TLE)
        // Arrays.fill(dp,-1);
        // return solveMem(envelopes, 0, -1, dp); 

        //Tabulation and space Opt. (created 2 arrays) (TLE)
        // return solveTab(envelopes, dp); 

        //Dp with binary search (O N*logN) (Most Optimal)
        return solveOpt(envelopes);
        
    }


    //Most Optimal

    //this gives us the least greater val than the target
    private int lowerBound(ArrayList<Integer> li, int targ){
        int l=0, h=li.size()-1;
        int ans=-1;
        
        while(l<=h){
            int mid = l+(h-l)/2;

            if(li.get(mid)<targ){
                l=mid+1;
            }
            else{
                ans=mid;
                h=mid-1;
            }
        }
        return ans;
    }

    private int solveOpt(int[][] nums){
        if(nums.length==0) return 0;

        ArrayList<Integer> li = new ArrayList<>();

        for(int i=0 ; i<nums.length ; i++){
            //if our height is > than the last height in our list we just add it in li
            if(i==0 || (nums[i][1] > li.get(li.size()-1))){
                li.add(nums[i][1]);
            }
            //else we found the lowerBound for the height and replace that index with that height
            else{
                li.set(lowerBound(li, nums[i][1]), nums[i][1]);
            }
            
        }
        
        return li.size();
    }




    private int solveTab(int[][] nums, int []dp){
        int prev[] = new int[dp.length];

        for(int i=nums.length-1 ; i>=0 ; i--){
            for(int prevIndex=i-1 ; prevIndex>=-1 ; prevIndex--){

                int pick = 0, notPick = 0;
                //I ignored the weight check here
                if(prevIndex==-1 || (nums[prevIndex][0] < nums[i][0] && nums[prevIndex][1] < nums[i][1])){  
                    pick = 1 + prev[i+1];
                }
                notPick = prev[prevIndex+1];

                dp[prevIndex+1] = Math.max(pick, notPick);  //prevIndex+1 to prevent the -ve case
            }
            //copying curr/dp to prev
            for(int j=0 ; j<dp.length ; j++){
                prev[j]=dp[j];
            }
        } 

        return dp[0];
    }


    private int solveMem(int[][] nums, int i, int prevIndex, int[]dp){
        if(i==nums.length){
            return 0;
        }

        if(prevIndex!=-1 && dp[prevIndex+1]!=-1){
            return dp[prevIndex+1];
        }   
  
        int pick = 0, notPick = 0;
        
        // u can ignore the width check as we have sorted the orig. envelopes arr acc. to increasing weight
        if(prevIndex==-1 || (nums[prevIndex][0] < nums[i][0] && nums[prevIndex][1] < nums[i][1])){  
            pick = 1 + solveMem(nums, i+1, i, dp);
        }
        notPick = solveMem(nums, i+1, prevIndex, dp);

        return dp[prevIndex+1] = Math.max(pick, notPick);  //prevIndex+1 to prevent the -ve case
    }
}
