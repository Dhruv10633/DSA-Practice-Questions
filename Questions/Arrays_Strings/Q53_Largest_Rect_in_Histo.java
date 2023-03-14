//https://leetcode.com/problems/largest-rectangle-in-histogram/
package Arrays_Strings;
import java.util.*;

class Solution {
    //Opt
    public int largestRectangleArea_OPT(int[] ht){
        //a 2 len arr for each bar denoting the leftmost position and the height index in the height array
        Stack<int[]> index=new Stack<>();

        int maxArea=0;

        for(int i=0 ; i<=ht.length ; i++){
            int temp=i;

            //if our curr bar smaller than the topmost stack bar
            while(!index.isEmpty() && (i==ht.length || ht[index.peek()[1]] > ht[i])){
                int height = ht[index.peek()[1]];
                int width = i-index.peek()[0];
                maxArea = Math.max(maxArea, width*height);

                //we need to change the left most index from i as the bars which are greater than the curr one
                //also contains the area of the curr bar
                temp=index.peek()[0];
                index.pop();
            }
            
            int arr[]={temp,i};
            index.push(arr);
        }
        
        return maxArea;
    }

    //////////////////////////////////////////////////////

    //Brut
    public int largestRectangleArea_BRUT(int[] heights) {
        Stack<Integer> index=new Stack<>();

        //prev smaller at each index
        int ps[]=new int[heights.length];

        for(int i=0 ; i<ps.length ; i++){
            while(!index.isEmpty() && heights[index.peek()] >= heights[i]){
                index.pop();
            }

            if(index.isEmpty()){
                ps[i]=-1;
            }
            else{
                ps[i]=index.peek();
            }
            index.push(i);
        }

        index=new Stack<>();

        //next smaller at each index
        int ns[]=new int[heights.length];

        for(int i=ns.length-1 ; i>=0 ; i--){
            while(!index.isEmpty() && heights[index.peek()] >= heights[i]){
                index.pop();
            }

            if(index.isEmpty()){
                ns[i]=heights.length;
            }
            else{
                ns[i]=index.peek();
            }
            index.push(i);
        }

        int maxArea=0;

        for(int i=0 ; i<heights.length ; i++){
            maxArea = Math.max(maxArea, heights[i] * (ns[i]-ps[i]-1));
        }

        return maxArea;
    }
}
