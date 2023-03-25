// https://leetcode.com/problems/combination-sum-ii/
package Recursion_Backtracking;
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int targ) {
        List<List<Integer>> ans=new ArrayList<>();

        //we want the all combinations to be ascending
        Arrays.sort(cand);
        comb(cand,0,targ,ans,new ArrayList<Integer>(), false);
    
        return ans;
    }

    //Pick-Not-Pick
    private void comb(int[] cand, int j, int targ,List<List<Integer>> ans,List<Integer> poss, boolean flag){
        
        if(targ==0){
            ans.add(new ArrayList<>(poss));
            return;
        }
        if(j==cand.length){
            return;
        }
        
        // To Avoid Repetion
        if(flag && cand[j]==cand[j-1]) {
            comb(cand,j+1,targ,ans,poss, true);
            return;
        }

        if(targ>=cand[j]){
            poss.add(cand[j]);
            comb(cand,j+1,targ-cand[j],ans,poss, false);
            poss.remove(poss.size()-1);
        }

        comb(cand,j+1,targ,ans,poss, true);
    }
}
