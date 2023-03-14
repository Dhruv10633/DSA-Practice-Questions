package Recursion_Backtracking;
import java.util.*;

class Solution {
    //Not Optimal

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set= subsets(nums,0,new ArrayList<Integer>());

        List<List<Integer>> ans=new ArrayList<>();

        for(List<Integer> x: set){
            ans.add(x);
        }

        return ans;
    }

    private HashSet<List<Integer>> subsets(int[] nums,int index,List<Integer> list){
        if(index>=nums.length){
            HashSet<List<Integer>> ans=new HashSet<>();
            ans.add(new ArrayList<>(list));
            return ans;
        }

        //Take the element at position
        list.add(nums[index]);
        HashSet<List<Integer>> take = subsets(nums,index+1,list);
        list.remove(list.size()-1);

        //Leave the element at position
        HashSet<List<Integer>> leave = subsets(nums,index+1,list);

        HashSet<List<Integer>> ans=new HashSet<>();

        for(List<Integer> x: take){
            ans.add(x);
        }
        for(List<Integer> x: leave){
            ans.add(x);
        }
        return ans;
    }


    //Optimal
    
}
