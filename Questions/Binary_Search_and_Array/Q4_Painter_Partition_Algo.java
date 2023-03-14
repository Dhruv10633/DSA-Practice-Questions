package Binary_Search_and_Array;
import java.util.*;


class Main {

	private static boolean isPoss(int[] arr, long mid, int nop){
		long time=0;
		nop--;
		for(int i=0;i<arr.length;i++){
			time += arr[i];
			if(time>mid){
				time=arr[i];
				nop--;
				if(nop<0){
				    return false;
				}
			}
		}
		
        return true;
	}

	private static void painterPartition(int[] arr, int nop){

		long l=Long.MIN_VALUE, h = 0;
		for(int i=0;i<arr.length;i++){
			l=Math.max(l, arr[i]);
			h+=arr[i];
		}
// 		System.out.println(nop+" "+nob);
		long ans=0;

		while(l<=h){
			long mid = (l) + (h-l)/2;
// 			System.out.println(mid);
			if(isPoss(arr, mid, nop)){
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

        int nop=sc.nextInt();
        int nob=sc.nextInt();

        int[] arr=new int[nob];

        for(int i=0;i<nob;i++){
            arr[i]=sc.nextInt();
        }

        painterPartition(arr, nop);
    }
}
