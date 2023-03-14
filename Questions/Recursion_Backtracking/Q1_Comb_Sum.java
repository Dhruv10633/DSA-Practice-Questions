//https://leetcode.com/problems/combination-sum/description/

package Recursion_Backtracking;
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] cand, int targ) {
        List<List<Integer>> ans=new ArrayList<>();
        comb(cand,targ,ans,new ArrayList<Integer>(),0);
        return ans;
    }

    //Pick-Not-Pick
    private void comb(int[] cand, int targ,List<List<Integer>> ans,List<Integer> poss,int i){

        if(i==cand.length){
            return;
        }

        if(targ==0){
            ans.add(new ArrayList<>(poss));
            return;
        }

        for(int j=i;j<cand.length;j++){   
            if(targ>=cand[j]){
                poss.add(cand[j]);
                comb(cand,targ-cand[j],ans,poss,j);
                poss.remove(poss.size()-1);
            }
            
        }
    }
}
