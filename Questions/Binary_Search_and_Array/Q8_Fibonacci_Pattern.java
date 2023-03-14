package Binary_Search_and_Array;
import java.util.*;

public class Q8_Fibonacci_Pattern {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();

        // int[] arr=new int[(n*(n+1))/2];

        int k=1;
        int l=2;

        int a=0;
        int b=1;
        for(int i=0;i<(n*(n+1))/2;i++){
            if(k==i){
                System.out.println();
                k+=l++;
            }
            
            // arr[i]=a;
            System.out.print(a+"   ");

            int sum=a+b;
            int temp=b;
            b=sum;
            a=temp;
        }
        sc.close();
    }
}
