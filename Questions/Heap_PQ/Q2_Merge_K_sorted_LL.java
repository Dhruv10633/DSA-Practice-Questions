//https://leetcode.com/problems/merge-k-sorted-lists/solutions/
package Heap_PQ;
import java.util.*;

// * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}



public class Q2_Merge_K_sorted_LL {
    // Heap from collections:
    //Min heap
    // PriorityQueue<Integer> minh= new PriorityQueue<>();

    //Max Heap
    // PriorityQueue<Integer> minh= new PriorityQueue<>(Collections.reverseOrder());
    
    public ListNode mergeKLists(ListNode[] lists) {
        //minHeap
       PriorityQueue<ListNode> minH = new PriorityQueue<>(new Comparator<ListNode>(){
           //we compare if parent o1.data < child o2.data  then we swap as we did in upheapify
           //it swaps if parent > child
           public int compare(ListNode o1,ListNode o2){
               return o1.val-o2.val;
           }
       });

       ListNode newH=new ListNode();
       ListNode finH=newH;

       for(int i=0; i<lists.length ;i++ ){
           //adding heads of all ll to the minH
           if(lists[i]!=null){
               minH.add(lists[i]);
           }
       }

       while(!minH.isEmpty()){
           //We add the least node of all the head nodes to the new LL
           ListNode temp=minH.poll();
           newH.next=temp;
           newH=newH.next;

           //We move the removed node head to next pos nad add it to minH
           if(temp.next!=null) minH.add(temp.next) ;
       }

       return finH.next;
   }
}
