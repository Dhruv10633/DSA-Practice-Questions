package Binary_Search_and_Array;
import java.util.*;

public class Q6_Print_unique_triplets {

    public static void triplets(int[] arr,int tar){
        Arrays.sort(arr);

        int n=arr.length;

        for(int i=0;i<n;i++){
            int l=i+1;
            int h=n-1;

            while(l<h){
                if(l-1>=0 && arr[l]==arr[l-1]){
                    l++;
                    continue;
                }
                if(h+1<n && arr[h]==arr[h+1]){
                    h--;
                    continue;
                }
                if(arr[i]+arr[l]+arr[h]==tar){
                    System.out.println(arr[i]+", "+arr[l]+" and "+arr[h]);  
                    l++;
                    h--;
                }
                else if(arr[i]+arr[l]+arr[h]<tar){
                    l++;
                }
                else{
                    h--;
                }
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int tar=sc.nextInt();
        triplets(arr, tar);
    }
}
