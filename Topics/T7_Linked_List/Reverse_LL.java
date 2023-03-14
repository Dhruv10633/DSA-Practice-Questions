package T7_Linked_List;

public class Reverse_LL {
    public static void main(String[] args) {

        Linked_List ll1=new Linked_List();
        ll1.addLast(1);
        ll1.addLast(2);
        ll1.addLast(3);
        ll1.addLast(4);
        ll1.addLast(5);

        Node h1=ll1.head;
        while(h1!=null){
            System.out.println(h1.data);
            h1=h1.next;
        }
    }
    
}
