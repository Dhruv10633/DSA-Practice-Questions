//https://leetcode.com/problems/sliding-window-maximum/
package Arrays_Strings;
import java.util.*;

class Solution {
    //Monotonic Queue
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Linked list as Deque
        LinkedList<Integer> win=new LinkedList<>();
        int[] ans=new int[nums.length-k+1]; //k number of str less ;
        int ptr=0;

        int s=0,e=0;

        //Creating the first Window
        for(; e<k ;e++){ 
            while(!win.isEmpty() && nums[win.peekLast()]<nums[e]){
                win.removeLast();
            }
            win.addLast(e);
        } 

        ans[ptr++]=nums[win.peekFirst()];
        
        for(;e<nums.length;e++){
            //Now we add the next num to the deque
            //We take the new number to be added and check from the last num in our queue if its greater we remove the last num,
            //else we add it to last
            while(!win.isEmpty() && nums[win.peekLast()]<nums[e]){
                win.removeLast();
            }
            win.addLast(e);
            
            //And also slide the window from the left side 
            //(this cond checks that if the number at s pos which we have to remove has already been removed or not)
            if(nums[s++]==nums[win.peekFirst()]){
                win.removeFirst();   
            }

            ans[ptr++]=nums[win.peekFirst()]; 
            
        }
        return ans;
    }
}