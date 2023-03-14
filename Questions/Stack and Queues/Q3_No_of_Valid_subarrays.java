// https://www.tutorialspoint.com/number-of-valid-subarrays-in-cplusplus#:~:text=So%2C%20if%20the%20input%20is,2%2C5%2C3%5D.

import java.util.*;

public class Q3_No_of_Valid_subarrays {

    public static void subarrays(int[] arr,int n) {
        Stack<Integer> st=new Stack<>();
        
        int valid=0;

        //We use Next smaller Element here
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && arr[st.peek()]>arr[i]){
                st.pop();
            }

            if(st.empty()){
                valid+=n-i;
            }

            else{
                valid+=st.peek()-i;
            }

            st.push(i);
        }
            
        System.out.print(valid);
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();

        subarrays(arr,n);
        

    }
}
