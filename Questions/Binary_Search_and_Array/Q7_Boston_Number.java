package Binary_Search_and_Array;
import java.util.*;

public class Q7_Boston_Number {
    
    public static int sum_of_digits(int n) {
        int sod=0;
        while(n!=0){
            sod+=n%10;
            n=n/10;
        }
        return sod;
    }

    public static void Boston(int n) {
        if(n==1 || n==2 || n==3 || n==5 || n==7){
            System.out.println(0);
            return;
        }

        int num=n;
        int i=2;
        int sum=0;
        while(num!=1 && i<=n/2){
            
            while(num!=1 && num%i==0){
                // System.out.println(i);
                sum+=sum_of_digits(i);
                num=num/i;
            }
            i++;
        }

        int sod=sum_of_digits(n);

        if(sod==sum){
            System.out.println(1);
            return;
        }
        else{
            System.out.println(0);
            return;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        Boston(n);
    }
}
