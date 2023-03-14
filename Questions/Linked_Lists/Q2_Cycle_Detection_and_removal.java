package Linked_Lists;
// import java.util.*;

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


public class Q2_Cycle_Detection_and_removal{

    public static void display(Node head){
        Node h1=head;
        while(h1!=null){
            System.out.print(h1.data+"->");
            h1=h1.next;
        }
        System.out.println();
        System.out.println();
    }

    public static void detect_and_remove(Node head) {
        boolean cycle=false;
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                cycle=true;
                break;
            }
        }

        if(cycle){

            slow=head;

            if(head==fast){
                while(fast.next!=slow){ //head works too
                    fast=fast.next;
                }   
                fast.next=null;
            }
            else{
                while(fast.next!=slow.next){
                    fast=fast.next;
                    slow=slow.next;
                }
                fast.next=null;
            }
            
        }

        System.out.println(cycle); 
    }
    public static void main(String[] args) {
        Linked_Lists ll=new Linked_Lists();
        ll.addLast(7);
        ll.addLast(1);
        ll.addLast(4);
        ll.addLast(0);
        ll.addLast(5);
        ll.addLast(9);
        ll.addLast(10);
        ll.addLast(11);

        //cycle
        ll.tail.next=ll.head.next.next; 
        detect_and_remove(ll.head);

        display(ll.head);

    }
}