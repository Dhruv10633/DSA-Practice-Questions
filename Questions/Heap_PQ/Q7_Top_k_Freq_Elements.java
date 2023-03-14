//https://leetcode.com/problems/top-k-frequent-elements/description/
package Heap_PQ;
import java.util.*;

class Solution {

    private class pair{
        int ele;
        int freq;
        pair(int e,int f){
            ele=e;
            freq=f;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];

        Map<Integer,Integer> mp=new HashMap<>();
        //Sorting the pairs acc to their freq but in case of equal freqs,
        //then the lower value element comes first
        PriorityQueue<pair> pq=new PriorityQueue<pair>((p1,p2)->(p1.freq!=p2.freq ? p2.freq-p1.freq : p1.ele-p2.ele));

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }

        for(int x:mp.keySet()){
            pq.add(new pair(x, mp.get(x)));
        }

        for(int i=0;i<k;i++){
            ans[i]=pq.remove().ele;
        }
        return ans;
    }
}