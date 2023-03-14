// https://leetcode.com/problems/maximal-rectangle/
import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        ans = maxArea(matrix[0]);

        for(int i=1 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ; j++){
                if(matrix[i][j]=='1'){
                    if(matrix[i-1][j]>='1'){
                        matrix[i][j] = (char)(matrix[i-1][j]+'1'-'0');
                    }
                }
                // System.out.print(matrix[i][j]+" ");
            }
            // System.out.println();

            ans = Math.max(ans, maxArea(matrix[i]));
        }

        return ans;
    }


    private int maxArea(char[] arr){
        Stack<Integer> st = new Stack<>();
        
        //prev Smaller
        int[] ps = new int[arr.length];

        for(int i=0 ; i<arr.length ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ps[i]=-1;
            }
            else{
                ps[i]=st.peek();
            }
            st.push(i);
        }

        //Next Smaller
        st = new Stack<>();
        int[] ns = new int[arr.length];

        for(int i=arr.length-1 ; i>=0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ns[i]=arr.length;
            }
            else{
                ns[i]=st.peek();
            }
            st.push(i);
        }

        //Max Area for this level
        int maxAr = 0;
        for(int i=0 ; i<arr.length ; i++){
            // System.out.println(arr[i]+" "+ns[i]+" "+ps[i]);
            if(arr[i] != '0') maxAr = Math.max(maxAr, (ns[i]-ps[i]-1)*(int)(arr[i]-'0'));
        }
        // System.out.println();
        return maxAr;
    }
}
