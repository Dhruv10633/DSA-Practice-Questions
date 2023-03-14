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

public class Q7_Check_Palindrome {
    
    public static void display(Node head){
        Node h1=head;
        while(h1!=null){
            System.out.print(h1.data+"->");
            h1=h1.next;
        }
        System.out.println();
        System.out.println();
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

    public static boolean check_Palindrome(Linked_Lists ll,int n) {
        if(n==1) return true;
        
        Node h1 = ll.head;
        Node h2 = reverse( mid(h1) );
        
        while(h1!=null && h2!=null){
            if(h1.data!=h2.data){
                return false;
            }

            h1=h1.next;
            h2=h2.next;
        }

        return true;
    }

    //Recursive soln (to prevent changing linked list itself or make a copy)
    // static Node start=null;
    // static boolean palin=true;
    // public static boolean check_Palin_tempfunc(Node head){
    //     // if(head==null || head.next==null){
    //     //     return palin;
    //     // }
    //     start=head;
    //     check_Palindrome_recurs(head);
    //     return palin;
    // }

    // public static void check_Palindrome_recurs(Node end){
    //     if(end==null){
    //         return;
    //     }
    //     check_Palindrome_recurs(end.next);
    //     if(end.data!=start.data){
    //         palin=false;
    //         return;
    //     }
    //     else{
    //         start=start.next;
    //     }
    // }

    static Node start=null;

    public static boolean check_Palin_tempfunc(Node head){
        // if(head==null || head.next==null){
        //     return palin;
        // }
        start=head;
        return check_Palindrome_recurs(head);
    }

    public static boolean check_Palindrome_recurs(Node end){
        if(end==null){
            return true;
        }
        check_Palindrome_recurs(end.next);
        if(start==null){
            return false;
        }
        else if(end.data!=start.data){
            start=null;
            return false;
        }
        else{
            start=start.next;
            return true;
        }
        // return false;
    }


    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        Linked_Lists ll=new Linked_Lists();
        for(int i=0;i<n;i++){
            ll.addLast(sc.nextInt());
        }
        
        System.out.println(check_Palindrome(ll, n));
        // System.out.println(check_Palin_tempfunc(ll.head));
    }   
}
