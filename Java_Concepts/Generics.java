// package Java_Concepts;
import java.util.*;

public class Generics {
    
    public static void main(String[] args) {
        Integer [] arr={10,20,30,40};   //int is a primitive val , Integer is a wrapper class 
        String[] str={"a","b","c","d"};

        display(arr);
        display(str);
    }


    //Generic Function:
    //works for all wrapper classes (not for primitive ones)
    public static <something> void display( something[] arr){
        System.out.println(Arrays.toString(arr));
    }
}


//Generic Class:

class LinkedList<xt>{

    // here instead of int we use "xt" so as to make the linked list for any data type
    LinkedList( xt[] arr){
        System.out.println(Arrays.toString(arr));
    }

    private void mm( xt ele) {
        // int ele=2 or String ele="Acdvs"
        System.out.println(ele);
    }
}


