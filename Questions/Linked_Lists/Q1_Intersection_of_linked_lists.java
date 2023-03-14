//https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/2116221/visual-explanation-one-pass-java/
import java.util.*;

class Node{
    int data;
    Node next=null;

    Node(int x){
        this.data=x;
        next=null;
    }
}

class Linked_Lists{

    Node head=null,tail=null;

    public void addLast(int data) {
        Node temp=new Node(data);
        if(head==null && tail==null){
            head=tail=temp;
        }
        else{
            tail.next=temp;
            tail=temp;
        }
    }   
}

public class Q1_Intersection_of_linked_lists {
    
    public static Node getIntersectionNode(Node headA,Node headB){
        // this also includes case if no intersection
        Node ptrA = headA, ptrB = headB;
        while (ptrA != ptrB) { // loop until we found the first common node
            ptrA = (ptrA == null) ? headB : ptrA.next; // once we're done with A, move to B
            ptrB = (ptrB == null) ? headA : ptrB.next; // once we're done with B, move to A
        }
        return ptrA;

    }

    public static void main(String[] args) {
        Linked_Lists ll1=new Linked_Lists();
        ll1.addLast(7);
        ll1.addLast(1);
        ll1.addLast(4);
        ll1.addLast(0);
        ll1.addLast(5);

        

        //Merge 2 Sorted
        Linked_Lists ll2=new Linked_Lists();
        ll2.addLast(1);
        ll2.addLast(3);
        ll2.addLast(5);
        ll2.addLast(7);
        ll2.addLast(9);
        ll1.tail.next=ll2.head.next.next;
        getIntersectionNode(ll1.head, ll2.head);
    }
}
