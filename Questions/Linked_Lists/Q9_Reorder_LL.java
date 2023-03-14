//https://leetcode.com/problems/reorder-list/description/
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

    void addLast(int data) {
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

public class Q9_Reorder_LL {
    public static void display(Node head){
        Node h1=head;
        while(h1!=null){
            System.out.print(h1.data+"->");
            h1=h1.next;
        }
        System.out.println();
        System.out.println();
    }

    public static Node mid(Node head) {
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        Node h2=slow.next;
        slow.next=null;
        return h2;
        
    }

    public static Node reverse(Node head) {
        Node curr=head;
        Node prev=null;
        Node nxt=head.next;

        while(nxt!=null){
            curr.next=prev;
            prev=curr;
            curr=nxt;
            nxt=curr.next;
        }
        curr.next=prev;
        return curr;

    }


    public static void reorderList(Node head){
        if(head==null || head.next==null || head.next.next==null){
            return;
        }
        Node h1=head;
        Node h2=reverse(mid(h1));

        int i=0;
        Node newHead=new Node(0);
        Node temp=null;

        while(h1!=null && h2!=null){

            if(i%2==0){
                temp=h1.next;
                newHead.next=h1;
                h1=temp;
                newHead=newHead.next;
            }
            else{
                temp=h2.next;
                newHead.next=h2;
                h2=temp;
                newHead=newHead.next;
            }
            i++;
        }

        if(h1!=null){
            newHead.next=h1;
        }
        if(h2!=null){
            newHead.next=h2;
        }

        head=newHead.next;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        Linked_Lists ll=new Linked_Lists();

        for(int i=0;i<n;i++){
            ll.addLast(sc.nextInt());
        }

        reorder(ll.head);
        display(ll.head);
    }
}
