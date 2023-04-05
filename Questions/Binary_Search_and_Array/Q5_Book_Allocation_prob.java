package Binary_Search_and_Array;
import java.util.*;

public class Q5_Book_Allocation_prob {
    
    public static Boolean isPoss(int[]arr,int mid,int nos) {
        int pages=0;
        int studs=1;
        for(int i=0;i<arr.length;i++){
            pages+=arr[i];

            if(pages>mid){
                // System.out.println("studs: "+studs);
                pages=arr[i];
                studs++;
                if(studs>nos){
                    return false;
                }
            }
        }
        return true;
    }

    public static void book_alloc(int[] arr,int nob,int nos) {
        Arrays.sort(arr);
        
        int l=arr[nob-1];
        int h=0;

        for(int i=0;i<nob;i++){
            h+=arr[i];
        }
        int ans=0;
        while(l<=h){
            int mid=(l+h)/2;
            // System.out.println(mid);
            if(isPoss(arr,mid,nos)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t--!=0){
            int nob=sc.nextInt();
            int nos=sc.nextInt();

            int[] arr=new int[nob];

            for(int i=0;i<nob;i++){
                arr[i]=sc.nextInt();
            }

            book_alloc(arr, nob,nos);
        }
        sc.close();
    }
}
