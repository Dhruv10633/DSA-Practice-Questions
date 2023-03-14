package Linked_Lists;
import java.util.*;

public class Q4_Kth_ele_from_last {


    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);

        ArrayList<Integer> list=new ArrayList<>();
        // String str=sc.nextLine();
        
        String[] arr=(sc.nextLine()).split(" ");
        int k=sc.nextInt();

        System.out.println(arr[arr.length-k-1]);

    }

}