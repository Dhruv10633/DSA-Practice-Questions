// https://leetcode.com/problems/maximum-score-of-a-good-subarray/
import java.util.*;

class Solution {
    public int maximumScore(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();

        int maxS = 0;

        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                int index = st.pop();
                int min = nums[index];
                int l, r=i-1;
                if(st.isEmpty()){
                    l =-1;
                }
                else{
                    l = st.peek();
                }
                l++;

                if(l<=k && k<=r){
                    int width = r-l+1;
                    // System.out.println(min+" "+width);
                    maxS = Math.max(maxS, min * width);
                }

            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int index = st.pop();
            int min = nums[index];
            int l, r = nums.length-1;
            if(st.isEmpty()){
                l =-1;
            }
            else{
                l = st.peek();
            }
            l++;

            if(l<=k && k<=r){
                int width = r-l+1;
                // System.out.println(min+" "+width);
                maxS = Math.max(maxS, min * width);
            }

        }

        return maxS;
    }
}
