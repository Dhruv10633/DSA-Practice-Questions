//https://leetcode.com/problems/copy-list-with-random-pointer/description/
package Linked_Lists;
import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        //eg : head = [[7,null],[13,0],[11,4],[10,2],[1,0]]

        if(head==null) return null;

        //creating a LL wit pattern 7-7-13-13-11-11-10-10-1-1
        Node h1=head;
        while(h1!=null){
            Node tNext=h1.next;
            Node nh=new Node(h1.val);
            h1.next=nh;
            nh.next=tNext;
            h1=tNext;
        }

        //assigning the random pointers
        h1=head;
        Node h2=head.next;
        while(h1!=null && h2!=null){
            if(h1.random!=null) h2.random=h1.random.next;
            else h2.random=null;

            h1=h1.next.next;
            if(h2.next!=null)h2=h2.next.next;
        }

        //breaking the above LL into 2 duplicate ones
        h1=head;
        h2=head.next;
        Node newHead=h2;
        while(h1!=null && h2!=null){
            h1.next=h1.next.next;
            if(h2.next!=null) h2.next=h2.next.next;

            h1=h1.next;
            h2=h2.next;
        }

        return newHead;
    }

    //HashMap
    public Node copyRandomList2(Node head) {
        //eg : head = [[7,null],[13,0],[11,4],[10,2],[1,0]]

        if(head==null) return null;

        //creating a hash map storing the address of the original ll node and the duplicate ll node
        HashMap<Node,Node> map=new HashMap<>();

        Node h1=head;
        Node h2=new Node(-1);
        Node newHead=h2;

        while(h1!=null){
            h2.next=new Node(h1.val);
            h2=h2.next;
            map.put(h1,h2);
            h1=h1.next;
        }


        for(Node t1:map.keySet()){
            Node t2 = map.get(t1);
            if(t1.random!=null) t2.random = map.get(t1.random);
        }

        return newHead.next;
    }
}
