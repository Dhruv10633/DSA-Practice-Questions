package Binary_Search_and_Array;

import java.util.*;

public class Q3_Aggressive_cows {

    public static Boolean isPoss(int[]arr,int mid,int noc) {
        //1st cow at 0
        int index=0;
        int cows=1;
        for(int i=1;i<arr.length;i++){
            int dist=arr[i]-arr[index];

            if(dist>=mid){
                // System.out.println("Cows: "+cows);
                index=i;
                cows++;
                if(cows>=noc){
                    return true;
                }
            }
        }
        return false;
    }

    public static void aggress_cows(int[] arr,int nos,int noc) {
        Arrays.sort(arr);
        int l=1; //min dist between 2 cows
        int h=arr[nos-1]; //max dist between 2 cows
        int ans=0;
        while(l<=h){
            int mid=(l+h)/2;
            // System.out.println(mid);
            if(isPoss(arr,mid,noc)){
                ans=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int nos=sc.nextInt();
        int noc=sc.nextInt();

        int[] arr=new int[nos];

        for(int i=0;i<nos;i++){
            arr[i]=sc.nextInt();
        }

        aggress_cows(arr, nos,noc);
    }
}
