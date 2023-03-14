// https://practice.geeksforgeeks.org/problems/sum-of-length3345/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
package Arrays_Strings;

import java.util.*;
class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int ans=0;

        ////BruteForce
        // Set<Set<Integer>> mainS=new HashSet<>();

        // for(int i=0;i<n;i++){
        //     int size=i+1;
            

        //     for(int j=0; j<n-i ;j++){
        //         Set<Integer> subS=new HashSet<>();

        //         for(int k=j; size+j <= n && k<size+j;k++){
        //             if(subS.contains(arr[k])) break;
        //             else subS.add(arr[k]);
        //         }
                
        //         if(!mainS.contains(subS)){
        //             mainS.add(subS);
        //             ans+=subS.size();
        //         }

        //     }
        // }


        //Optimised - Sliding Window And Aritmetic Progression sum
        Set<Integer> window=new HashSet<>();

        int s=0;

        for(int i=0;i<n;i++){

            //till we find the duplicate element we keep on deleting the elements from s pos
            while(window.contains(arr[i])){
                window.remove(arr[s]);
                s++;
            }
            window.add(arr[i]);

            //Size of distinct substring;
            int sz=i-s+1;

            //sum of all length subarr of size eg for sz=3 (1 3len ,2 3len,3 1 len)(1+2+3) (AP)

            ans+= sz*(sz+1)/2;

        }

        System.out.println(ans% 1000000007);

        sc.close();
    }
}
