//For every Kth operation from an array:
//1. Rotate The arr clockwise by 1
//2. Delete the (n-k+1)th element
//return the last element left

package Arrays_Strings;
import java.util.*;

public class Q2_Rotate_the_arr_and_delete {
      
    public static void rotate_delete(ArrayList<Integer> li) {
        int n=li.size();
        int k=1;

        while(n>1){
            
            //rotate clockwise
            //inserting last ele to 1st
            li.add(0,li.get(n-1));
            //deleting last ele
            li.remove(n);

            //Print a list
            // for(int i:li){
            //     System.out.print(i);
            // }
            // System.out.println();

            int temp= (n-k >=0)? n-k : 0 ;
            li.remove(temp);

            n--;
            k++;
        }
        System.out.println(li.get(0));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        ArrayList<Integer> li=new ArrayList<>();
        while(sc.hasNext()){
            li.add(sc.nextInt());
        }

        rotate_delete(li);
        sc.close();
    }
}
