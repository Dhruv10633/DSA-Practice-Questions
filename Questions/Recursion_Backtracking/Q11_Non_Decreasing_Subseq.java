//https://leetcode.com/problems/non-decreasing-subsequences/description/
package Recursion_Backtracking;
import java.util.*;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {  
        HashSet<List<Integer>> set=new HashSet<>();
        subSeq(nums, 0, new ArrayList<Integer>(), set);

        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> temp:set){
            ans.add(temp);
        }
        return ans;
    }

    private void subSeq(int[] nums,int x, List<Integer> li, HashSet<List<Integer>> set){
        
        if(li.size()>=2){
            set.add(new ArrayList<>(li));
        }
        if(x >= nums.length){          
            return ;
        }

        //Pick
        if(li.isEmpty() || li.get(li.size()-1) <= nums[x]){
            li.add(nums[x]);
            subSeq(nums, x+1, li, set);
            li.remove(li.size()-1);
        }

        //Not Pick
        subSeq(nums, x+1, li, set);
    }
}