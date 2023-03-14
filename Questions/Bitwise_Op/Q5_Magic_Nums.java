// package Bitwise_Op;
import java.util.*;

public class Q5_Magic_Nums {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        
        int power=1;
        int ans=0;
        //basically it is a number with base 5
        //like how we convert a bin num to decimal (by multiplying 2 power something from right)
        // we convert this 5 base num to decimal (by multiplying 5 power something from right)
        while(n>0){
            if((n&1)==1) ans+=(int) Math.pow(5,power);
            power++;
            n>>=1;
        }
        System.out.println(ans);

        sc.close();
    }
}
