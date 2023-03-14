// https://www.tutorialspoint.com/number-of-valid-largestHistograms-in-cplusplus#:~:text=So%2C%20if%20the%20input%20is,2%2C5%2C3%5D.

import java.util.*;

public class Q4_Histogram {

    //using 2arrays by taking PS and NS
    public static void largestHistograms(int[] arr,int n) {
        Stack<Integer> st=new Stack<>();
        
        int[] ns=new int[n];

        //Next smaller Element here
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(st.empty()){
                ns[i]=n;
            }

            else{
                ns[i]=st.peek();
            }

            st.push(i);
        }

        st.clear();
        //Prev smaller
        int[] ps=new int[n];
        
        for(int i=0;i<n;i++){
            while(!st.empty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.empty()){
                ps[i]=-1;
            }
    
            else{
                ps[i]=st.peek();
            }
            st.push(i);
    
        }


        long max_area=0;
        for(int i=0;i<n;i++){
            max_area=Math.max(arr[i]*(ns[i]-ps[i]-1) , max_area);
        }
        System.out.println(max_area);

    }


    public static void largestHistogramsEff(int[] arr,int n){

        Stack<Integer> st=new Stack<>();
        int max_area=0;
        for(int i=0;i<n;i++){
            while(!st.empty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            int r;
            if(st.empty()){
                r=n;
            }
            else{
                r=i;
            }

            max_area=Math.max(max_area , arr[i]*(r));
            st.push(i);


        }
        System.out.println(max_area);
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();

        // largestHistograms(arr,n);
        largestHistogramsEff(arr,n);

    }
}
