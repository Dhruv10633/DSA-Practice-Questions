package Topics.T6_Sorting;
import java.util.*;

public class Quick_Sort {

    //Worst Case is O(N^2) in case of sorted or reverse sorted arr

    ///!!!!!!!!!!!!!!!!! only Works if u take the pivot as low
    public static int partition(int[] arr,int l,int h) {
        int pivot_pos=l;
        int pivot=arr[pivot_pos];
        int temp=-1;

        while(l<h){
            while(arr[l]<=pivot){
                l++;
            }       
            while(arr[h]>pivot){
                h--;
            }        
            if(l>=h){
                break;
            }
            temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
        }

        temp=arr[h];
        arr[h]=arr[pivot_pos];
        arr[pivot_pos]=temp;

        // System.out.println(h+" "+pivot);
        return h;

    }

    public static void quickSort(int[] arr,int l,int h) {
        if(l>h){
            return;
        }
        int pivot=partition(arr,l, h);
        quickSort(arr, l, pivot-1);
        quickSort(arr, pivot+1, h);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        quickSort(arr, 0, n-1);
        
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        
        sc.close();
    }
}
