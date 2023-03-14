//https://hack.codingblocks.com/app/contests/3830/720/problem

package Arrays_Strings;

import java.util.*;
class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int[] unSorted=new int[n];
        int[] pos=new int[n+1];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();

            unSorted[i]=temp;
            pos[temp]=i;
        }

        for(int j=0,num=n; j<n && k>0 ;num--,j++){

            if(num!=unSorted[j]){
                k--;

                int rtPos = pos[num];

                int temp=pos[num];
                pos[num]=pos[unSorted[j]];
                pos[unSorted[j]]=temp;

                temp = unSorted[j];
                unSorted[j]=unSorted[rtPos];
                unSorted[rtPos]=temp;
                     
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(unSorted[i]+" ");
        }

        sc.close();
    }
}
