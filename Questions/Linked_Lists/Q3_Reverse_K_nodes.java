import java.util.*;

class Node{
    int data=0;
    Node next=null;

    Node(int k){
        data=k;
    }
}

class Linked_List{
    Node head=null;
    Node tail=null;

    public void addLast(int k){
        Node temp=new Node(k);

        if(head==null){
            head=tail=temp;
        }
        else{
            tail.next=temp;
            tail=temp;
        }
    }
}

public class Q3_Reverse_K_nodes {

    public static void display(Node head){
        Node h=head;

        while(h!=null){
            System.out.print(h.data+" ");
            h=h.next;
        }
    }

    public static Node reverse_k(Node head,int k){
        Node prev=null;
        Node curr=head;
        Node nxt=curr.next;

        while(nxt!=null && k-->1){
            curr.next=prev;
            prev=curr;
            curr=nxt;
            nxt=curr.next;
        }
        //linking the head node    which after reversing is tail to the next node
        //to make it continuous
        head.next=nxt;
        curr.next=prev;  //Basic reverse complete

        return  curr;
    }

    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int k=sc.nextInt();

        Linked_List ll=new Linked_List();
        
        for(int i=0;i<n;i++){
            ll.addLast(sc.nextInt());
        }

        //Main part starts here

        //Exceptions
        if(n==0 || k==0 || k==1 ){
            display(ll.head);
            return ;
        }

        Node curr=ll.head;
        Node temp=null,prev_curr=null;
        int check=0;

        while(curr!=null){

            temp=reverse_k(curr,k);

            //only for the 1st reverse as list head changes here
            if(check==0){
                ll.head=temp;
            }

            if(check!=0){
                prev_curr.next=temp;
            }
            
            prev_curr=curr;
            curr=curr.next;
            check++;
        }

        display(ll.head);
    }
}