// https://leetcode.com/problems/linked-list-random-node/solutions/3278243/java-using-reservoir-sampling/
package Linked_Lists;
import java.util.*;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


//Extra Space
class Solution1 {
    ArrayList<Integer> list = new ArrayList<>();
    Solution1(ListNode head) {
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
    }
    
    public int getRandom() {
        double rand=Math.random()*list.size();
        return list.get((int)rand);
    }
}

//ReserVoir Sampling
class Solution2 {
    ListNode head;
    public Solution2(ListNode head) {
        this.head=head;
    }
    
    public int getRandom() {
        ListNode node=head;
        int counter=0, res=0;
        while (node!=null){
            // R. Algo: k/k+counter probablity to be put into reservoir. where k is the size of reservoir=1
            counter++;
            if ((int)(Math.random()*counter)==0) res=node.val;
            node=node.next;
        }
        return res;       
    }
}
