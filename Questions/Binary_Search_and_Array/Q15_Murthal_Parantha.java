// https://hack.codingblocks.com/app/contests/4086/102/problem

/*
Sample Input
10
4 
1 2 3 4

Sample Output
12

Explanation:

First cook with rank 1 cooks 4 paranthas in 10 minutes (1+2+3+4).
Second cook with rank 2 cooks 3 paranthas in 12 minutes (2+4+6)
Third cook with rank 3 cooks 2 paranthas in 9 minutes (3+6) Fourth cook with rank 4 only needs to cook one last remaining parantha. He can do that in 4 minutes.
Since these cooks cook parallely, the total time taken will be the maximum of the four i.e. 12 minutes.
 */
package Binary_Search_and_Array;
import java.util.*;

class Main {

	private static boolean isPoss(int[] cooks, long mid, int nop){
		//check for all cooks the number of paranthas they can cook till that time
		for(int i=0; i<cooks.length; i++){
			int cnt = 1;
			long time = 0;

			while(time + cnt * cooks[i] <= mid && nop > 0){
				time += cnt * cooks[i];
				nop--;
				cnt++;
			}
			if(nop==0) return true;
		}

		return false;
	}

	private static void minTime(int[] cooks, int nop, int noc){	

		long l=Integer.MAX_VALUE ,h;

		for(int i =0;i<noc;i++){
			l=Math.min(l, cooks[i]);
		}	
		h = (nop*(2*l + (nop-1)*l))/2;

		long ans = 0;

		while(l<=h){
			long mid = l+(h-l)/2;

			if(isPoss(cooks, mid, nop)){
				ans=mid;
				h=mid-1;
			}
			else{
				l=mid+1;
			}
		}

		System.out.println(ans);

	}

    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int nop = sc.nextInt();
		int noc = sc.nextInt();

		int cooks[] = new int[noc];
		for(int i=0;i<noc;i++){
			cooks[i] = sc.nextInt();
		}

		minTime(cooks, nop, noc);
        sc.close();
    }
}
