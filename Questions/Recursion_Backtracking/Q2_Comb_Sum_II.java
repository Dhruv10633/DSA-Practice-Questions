// https://leetcode.com/problems/combination-sum-ii/
package Recursion_Backtracking;

import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int targ) {
        List<List<Integer>> ans=new ArrayList<>();

        //we want the all combinations to be ascending
        Arrays.sort(cand);
        comb(cand,targ,ans,new ArrayList<Integer>(),0);
    
        return ans;
    }

    //Pick-Not-Pick
    private void comb(int[] cand, int targ,List<List<Integer>> ans,List<Integer> poss,int i){
        //this cond filas if the last element itself == target
        // if(i==cand.length){
        //     return;
        // }

        if(targ==0){
            ans.add(new ArrayList<>(poss));
            return;
        }

        for(int j=i;j<cand.length;j++){  
            //if we take 2 loops then it works for the internal loop every time but not for the main one or the 1st time the loop exectues
            if((j>i) && cand[j]==cand[j-1]) continue; 

            if(targ>=cand[j]){
                poss.add(cand[j]);
                comb(cand,targ-cand[j],ans,poss,j+1);
                poss.remove(poss.size()-1);
            }
            
        }
    }
}
