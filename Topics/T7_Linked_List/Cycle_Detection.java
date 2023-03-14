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


public class Cycle_Detection{

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
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                cycle=true;
                break;
            }
        }

        if(cycle){
            System.out.println("Cycle Detected");

            slow=head;
            while(true){
                slow=slow.next;
                if(fast.next==slow){
                    System.out.println(fast.data + " "+fast.next.data);
                    fast.next=null;
                    return;
                }
                fast=fast.next;
            }
        }
        else{
            System.out.println("No Cycle");
        }
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