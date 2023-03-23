// https://leetcode.com/problems/largest-rectangle-in-histogram/description/

import java.util.*;

class Solution {
    public int largestRectangleArea(int[] ht) {
        //a 2 len arr for each bar denoting the leftmost position and the height index in the height array
        Stack<Integer> index=new Stack<>();

        int maxArea=0;

        for(int i=0 ; i<ht.length ; i++){

            //if our curr bar smaller than the topmost stack bar
            while(!index.isEmpty() && ht[index.peek()] > ht[i] ){   
                int x = index.pop();
                int height = ht[x];
                int l;
                if(index.isEmpty()){
                    l=-1;
                }
                else{
                    l=index.peek();
                }

                int width = i-l-1;

                // System.out.println(height + " "+ width);
                maxArea = Math.max(maxArea, height*width);
            }
            
            index.push(i);
        }

        while(!index.isEmpty()){   
            int x = index.pop();
            int height = ht[x];
            int l;
            if(index.isEmpty()){
                l=-1;
            }
            else{
                l=index.peek();
            }

            int width = ht.length-l-1;

            maxArea = Math.max(maxArea, height*width);
        }
        
        return maxArea;
    }
}

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


}

