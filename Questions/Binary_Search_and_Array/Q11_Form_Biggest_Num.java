package Binary_Search_and_Array;
import java.util.*;
public class Q11_Form_Biggest_Num {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0){
            int m=sc.nextInt();
            String arr[]=new String[m];

            for(int i=0;i<m;i++){
                arr[i]=sc.next();
            } 
            Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));
            System.out.println(String.join("",arr));    
        
        }
        sc.close();
    }
}
