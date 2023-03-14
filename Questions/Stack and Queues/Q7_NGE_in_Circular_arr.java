import java.util.*;

public class Q7_NGE_in_Circular_arr {
    
    public static void NGE_circ_arr(int[] arr,int n) {
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!st.empty() && arr[st.peek()%n]<=arr[i%n]){
                st.pop();
            }

            if(st.empty()){
                ans[i%n]=-1;
            }
            else{
                ans[i%n]=st.peek()%n;
            }
            st.push(i%n);
        }

        for(int i=0;i<n;i++){
            if(ans[i]==-1) System.out.print(-1+" ");
            else System.out.print(arr[ans[i%n]]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();

        NGE_circ_arr(arr,n);

    }
}
