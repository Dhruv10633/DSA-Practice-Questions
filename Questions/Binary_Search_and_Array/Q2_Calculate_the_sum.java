package Binary_Search_and_Array;
//https://hack.codingblocks.com/app/contests/3681/61/problem

import java.util.*;

public class Q2_Calculate_the_sum{

    public static void cal_sum(int[] arr,int n,int k) {
        int[] copy_arr=new int[n];

        for(int i=0;i<n;i++){
            copy_arr[i]=arr[i];
        }

        for(int i=0;i<n;i++){
            int temp=(i-k)>=0 ? (i-k):(n-k+i); 
            arr[i]=arr[i]+copy_arr[temp];
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int t=sc.nextInt();

        while(t--!=0){
            int k=sc.nextInt();
            cal_sum(arr,n,k);
        }

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}
