package Binary_Search_and_Array;
//https://hack.codingblocks.com/app/contests/3681/1314/problem

import java.util.*;

public class Q10_Incre_Decre_seq {

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            
            arr[i]=sc.nextInt();
            
        }

        Boolean check_desc=true;
        Boolean fin_check=true;
        for(int i=1;i<n-1;i++){
            // here >= because strictly decreasing
            if(check_desc && arr[i]>=arr[i-1]){
                check_desc=false;
            }
            if(check_desc==false){
                // System.out.println(arr[i]);
                // here <= because strictly increasing
                if(arr[i]>=arr[i+1]){
                    fin_check=false;
                }
            }
        }
      
        System.out.println(fin_check);
        sc.close();
        
    }
}
