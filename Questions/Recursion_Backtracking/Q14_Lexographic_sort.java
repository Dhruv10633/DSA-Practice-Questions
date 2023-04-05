/* 
Sample Input
10
Sample Output
0 1 10 2 3 4 5 6 7 8 9 
*/

package Recursion_Backtracking;
import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();

		List<Integer> li = new ArrayList<>();
		li.add(0);
		dfs(1, n, li);

		for(int x:li){
			System.out.print(x+" ");
		}
        sc.close();
    }


	private static void dfs(int i, int n, List<Integer> ll){
		if(i>n) return;

		ll.add(i);

		dfs(i*10, n, ll);

		if(i%10 !=9){
			dfs(i+1, n, ll);
		}
	}
}

