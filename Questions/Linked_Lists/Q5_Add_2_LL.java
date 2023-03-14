package Linked_Lists;
import java.util.*;

public class Q5_Add_2_LL {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);

        int m=sc.nextInt();
        int n=sc.nextInt();

        LinkedList<Integer> l1=new LinkedList<>();
        LinkedList<Integer> l2=new LinkedList<>();


        while(m--!=0){
            l1.addLast(sc.nextInt());
        }

        while(n--!=0){
            l2.addLast(sc.nextInt());
        }

        LinkedList<Integer> ans=new LinkedList<>();

        m=l1.size()-1;
        n=l2.size()-1;
        int carry=0;

        while(m>=0 && n>=0){
            int sum = l1.get(m) + l2.get(n) + carry;

            ans.addFirst( sum % 10 );
            carry=sum/10;
            m--;
            n--;
        }

        while(m>=0){
            int sum=carry + l1.get(m);
            ans.addFirst(sum % 10);
            carry = sum/10;
            m--;
        }

        while(n>=0){
            int sum=carry + l2.get(n);
            ans.addFirst(sum % 10);
            carry = sum/10;
            n--;
        }
        if(carry>0){
            ans.addFirst(carry);
        }

        for(int i:ans){
            System.out.print(i+" ");
        }
        sc.close();
    }
}
 
