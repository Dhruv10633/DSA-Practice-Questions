package Binary_Search_and_Array;
import java.util.*;

public class Q1_Kth_root{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t--!=0){
            Long n,k;

            n=sc.nextLong();
            k=sc.nextLong();

            if(n==1 || k==1){
                System.out.println(n);
                continue;
            } 
            
            Long low=1L;
            Long high=(long) Math.sqrt(n);

            Long kth_root=1L;

            while(low<=high){
                Long mid=(low+high)/2;
                // dont make a temp and type cast the Math.pow()
                // could lead to problems for very large num
                
                if(Math.pow(mid,k)==n){
                    kth_root=mid;
                    break;
                }

                else if(Math.pow(mid,k)<n){
                    kth_root=mid;
                    low=mid+1;
                    
                }

                else{
                    high=mid-1;
                }
            }

            System.out.println(kth_root);
        }
        sc.close();
    }
}