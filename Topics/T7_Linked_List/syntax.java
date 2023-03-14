// size of an object of class is always const (4bytes)
// as it only contains the address of the class as a hexadecimal in num (which has space of 4bytes)
import T7_Linked_List.*;
import java.util.*;

public class syntax {
    public static void main(String[] args) {
        // Creating object of the
        // class linked list
        LinkedList<String> ll = new LinkedList<String>();
 
        // Adding elements to the linked list
        ll.add("A");
        ll.add("B");
        ll.addLast("C");
        ll.addFirst("D");
        ll.add(2, "E");
        
        //Iterator

        Iterator<String> val=ll.iterator();  //<String> is the data type of the iterator we want it to be

        while(val.hasNext()){
            System.out.println(val.next());
        }

        System.out.println(ll);
 
        ll.remove("B");
        ll.remove(3);
        ll.removeFirst();
        ll.removeLast();
 
        System.out.println(ll);
    }
}
