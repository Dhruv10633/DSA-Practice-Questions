//https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/
package Heap_PQ;
import java.util.*;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        //MaxHeap
        PriorityQueue<Integer> maxH=new PriorityQueue<>((a,b)->(b-a));

        int sum=0;
        for(int i=0;i<piles.length;i++){
            sum+=piles[i];
            maxH.add(piles[i]);
        }
        
        while(k--!=0){
            int x=maxH.remove();
            sum-=x;
            x-=x/2;
            sum+=x;
            maxH.add(x);
        }
        return sum;
    }
}
