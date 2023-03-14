import java.util.*;

//CREATE all Function within main class

public class Q2_Next_Greater_Element {

    public static void NGE(int[] arr,int n) {
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];

        for(int i=n-1;i>=0;i--){

            while(!st.empty() && st.peek()<=arr[i]){
                st.pop();
            }

            if(st.empty()){
                ans[i]=-1;
            }

            else{
                ans[i]=st.peek();
            }

            st.push(arr[i]);
        }
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
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
        NGE(arr,n);
        
    }
}
