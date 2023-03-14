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




public class Q6_Merge_Sort_LL{
    
    public static void display(Node head){
        Node h1=head;
        while(h1!=null){
            System.out.print(h1.data+"->");
            h1=h1.next;
        }
        System.out.println();
        System.out.println();
    }

    public static Node merge2Sorted(Node ll1 ,Node ll2){
        if(ll1==null){
            return ll2;
        }
        if(ll2==null){
            return ll1;
        }
        Node fin=new Node(-2345);
        Node fin_head=fin;
        while(ll1!=null && ll2!=null){
            if(ll1.data<=ll2.data){
                fin.next=ll1;
                ll1=ll1.next;
            }
            else{
                fin.next=ll2;
                ll2=ll2.next;
            }
            fin=fin.next;
        }

        if(ll1!=null){
            fin.next=ll1;
        }
        if(ll2!=null){
            fin.next=ll2;
        }

        return fin_head.next;
    }

    public static Node middle(Node head) {
        Node slow=head;
        Node fast=head.next;   //imp for merge sort
                               //because fat= head fails when we have ll of size 2
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static Node Merge_Sort(Node head){
        if(head==null || head.next==null){
            return head;
        }

        Node mid=middle(head);
        Node head2=mid.next;
        mid.next=null;
        head = Merge_Sort(head);
        head2 = Merge_Sort(head2);

        return merge2Sorted(head, head2);

    }
    // We are dividing the list into two parts at each step till each sublist contains only one element, 
    // so the number of levels in this tree would be log2n, and at these different levels, while merging back the list, 
    // we will at max compare n elements. So the time complexity of the merge sort is θ(n*log2n).

    // The time complexity of Merge Sort in worst, average, and best case is θ(n*log2n)  
    // as merge sort always divides the list into two halves regardless of the fact that what is the present state of the list and takes linear time to merge the list.
    public static void main(String[] args) {
        Linked_Lists ll2=new Linked_Lists();
        ll2.addLast(1);
        ll2.addLast(3);
        ll2.addLast(5);
        ll2.addLast(7);
        ll2.addLast(9);

        Linked_Lists ll3=new Linked_Lists();
        ll3.addLast(0);
        ll3.addLast(2);
        ll3.addLast(4);
        ll3.addLast(6);
        ll3.addLast(8);
        
        display(ll2.head);
        display(ll3.head);

        display(merge2Sorted(ll2.head,ll3.head));
        
        //Middle
        // System.out.println(middle(ll.head).data);

        //Merge_Sort
        display(ll.head);
        display(Merge_Sort(ll.head));
    }
}

