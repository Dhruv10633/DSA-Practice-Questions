//https://leetcode.com/problems/subsets/
package Recursion_Backtracking;
import java.util.*;

class Solution {
    //Recursion Backtrack
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums,0,new ArrayList<Integer>());
    }

    private List<List<Integer>> subsets(int[] nums,int index,List<Integer> list){
        if(index>=nums.length){
            List<List<Integer>> ans=new ArrayList<>();
            ans.add(new ArrayList<>(list));
            return ans;
        }

        //Take the element at position
        list.add(nums[index]);
        List<List<Integer>> take = subsets(nums,index+1,list);
        list.remove(list.size()-1);

        //Leave the element at position
        List<List<Integer>> leave = subsets(nums,index+1,list);

        List<List<Integer>> ans=new ArrayList<>();

        for(List<Integer> x: take){
            ans.add(x);
        }
        for(List<Integer> x: leave){
            ans.add(x);
        }
        return ans;
    }


    //Bit Manipulation  
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();

        //for [1,2,3] we take total 7 which is 1 1 1 in bin form
        int total=(int) Math.pow(2,nums.length)-1;

        //we start from 000 and goes til 111 and also printing the array ele along the way
        for(int i=0;i<=total;i++){
            List<Integer> li=new ArrayList<>();
            int pos=0;
            int temp=i;

            //we are actually traversing its binary form here
            while(temp>0){
                if((temp & 1)==1) li.add(nums[pos]);
                pos++;
                temp=temp>>1;
            }
            ans.add(li);
        }
        return ans;
    }

}
