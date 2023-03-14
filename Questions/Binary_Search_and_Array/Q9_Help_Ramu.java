package Binary_Search_and_Array;
//https://hack.codingblocks.com/app/contests/3681/1089/problem
import java.util.*;

public class Q9_Help_Ramu {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int t=sc.nextInt();

        while(t--!=0){
            int c1=sc.nextInt();
            int c2=sc.nextInt();
            int c3=sc.nextInt();
            int c4=sc.nextInt();

            int nor=sc.nextInt();
            int noc=sc.nextInt();

            int[] arr_r=new int[nor];
            int[] arr_c=new int[noc];

            int tcr=0;
            for(int i=0;i<nor;i++){
                arr_r[i]=sc.nextInt();
                tcr+=Math.min(arr_r[i]*c1,c2);
            }
            tcr=Math.min(tcr,c3);

            int tcc=0;
            for(int i=0;i<noc;i++){
                arr_c[i]=sc.nextInt();
                tcc+=Math.min(arr_c[i]*c1,c2);
            }
            tcc=Math.min(tcc,c3);

            System.out.println(Math.min(tcc+tcr,c4));
        }
        sc.close();
    }
}
