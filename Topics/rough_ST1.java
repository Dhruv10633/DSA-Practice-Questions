package Topics;
import java.util.*;

public class rough_ST1 {

    public static void prime_factors(int n) {
        int[] arr=new int[100];
        int count=0;
        int i=2;
        while(n!=1){
            if(n%i==0){
                arr[count]=i;
                while(n%i==0){
                    n=n/i;
                }
                count++;
            }
            
            i++;
        }
        for(int k=0;k<100;k++){
            if(arr[k]==0) break;
            System.out.print(arr[k]+" ");
        }
    }

    public static void GCD(int n,int n2) {
        if(n==0){
            System.out.println(n2);
        }
        GCD(n2%n,n);
    }

    //Distribute in Circle : Find the last pos in circle that gets the last element
    public static void distribute(int size,int ele,int pos) {
        //Method 1 just iterate the array of size as circular array distributing the ele from given pos

        //Method 2  
        //size elements left after circling an arr 
        
        int ele_left = ele%size;

        int ans = pos+ele_left -1;
        if(ans<=size){
            System.out.println(ans);
            return;
        }
        else{
            ans = ans%size;
            System.out.println(ans);
            return;
        }

    }
    
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        // prime_factors(n);

        int n2=sc.nextInt();
        // GCD(n,n2);

        int n3=sc.nextInt();
        distribute(n,n2,n3);

        sc.close();
    }
}
