package Linked_Lists;
import java.util.*;

public class Q8_K_append {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        LinkedList<Integer> ll=new LinkedList<>();

        for(int i=0;i<n;i++){
            ll.add(sc.nextInt());
        }

        int k=sc.nextInt();

        for(int i=0;i<k;i++){
            ll.add(0 , ll.get(n-1));
            // System.out.print(ll);

            ll.remove();

            // System.out.println(ll);
        }

        for(int j:ll){
            System.out.print(j+" ");
        }
        sc.close();
        
    }
}

