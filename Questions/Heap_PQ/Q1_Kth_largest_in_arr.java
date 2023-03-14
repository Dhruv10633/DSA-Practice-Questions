// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
package Heap_PQ;
import java.util.*;

public class Q1_Kth_largest_in_arr {
    // TC: O(n log k)
    public int findKthLargest(int[] nums, int k) {
        //Min heap
        PriorityQueue<Integer> minH= new PriorityQueue<>();

        //Max Heap
        //PriorityQueue<Integer> maxH= new PrioritytQueue<>(Collections.reverseOrder());
        //PriorityQueue<Integer> maxH = new PriorityQueue<>((a,b)->(b-a));

        //Adding 1st 4 ele in a minH of size k
        for(int i=0;i<k;i++){
            minH.add(nums[i]);
        }

        for(int i=k ;i<nums.length ;i++){
            if(nums[i]>minH.peek()){
                //to remove the top element from the minH (which is the smallest element in the minH)
                minH.remove();
                minH.add(nums[i]);
            }
        }

        return minH.peek();
    }
}
