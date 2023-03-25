// https://leetcode.com/problems/subsets-ii/
package Recursion_Backtracking;
import java.util.*;


//Not Optimal
class Solution {

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
}


//Optimal

class Solution_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return sol(nums,0,new ArrayList(),false);
    }


    public List<List<Integer>> sol(int arr[],int idx,List<Integer>list,boolean flag)
    {
        List<List<Integer>>ans=new ArrayList();

        if(idx>=arr.length){
            List<Integer> temp=new ArrayList(list);
            ans.add(temp);
            return ans;
        }
        
        //if we have skipped the last ele then if the curr ele is also same as last ele we skip
        if(flag==true && arr[idx-1]==arr[idx])
        {
            List<List<Integer>> skip=sol(arr,idx+1,list,true);
            for(List<Integer> x:skip)
            {
                ans.add(x);
            }
            return ans;
        }
        
        //Pick
        list.add(arr[idx]);
        List<List<Integer>> take=sol(arr,idx+1,list,false);
        list.remove(list.size()-1);

        //Not-Pick
        List<List<Integer>> skip=sol(arr,idx+1,list,true); 
      
        for(List<Integer> x: take){
            ans.add(x);
        }
        for(List<Integer> x: skip){
            ans.add(x);
        }
        return ans;
    }
}