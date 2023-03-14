//https://leetcode.com/problems/maximal-rectangle/
package Arrays_Strings;
import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea=0;
        
        //to keep the sum of the previous consecutive vertical '1's in row
        int sum[]=new int[matrix[0].length];

        for(int i=0 ; i<matrix.length ; i++){
            
            //arr of len 2 to store the index of the leftmost value and the height index of the corresponding bar 
            Stack<int[]> index=new Stack<>();

            for(int j=0 ; j<=matrix[i].length ; j++){

                //for 1st row
                if(i==0 && j!=matrix[i].length){
                    sum[j] = matrix[i][j]-'0';
                }  
                //for all other rows 
                else if(i!=0 && j!=matrix[i].length){
                    //if there is '1' then we add to the prev sum
                    if(matrix[i][j]=='1')
                        sum[j] += (matrix[i][j]-'0');

                    //else we make the sum 0 if the sequnce of '1's break
                    else
                        sum[j] = 0;
                }

                //to store the left most index of the jth col of height=sum[j]
                int temp=j;

                //if our curr height smaller than the topmost stack col height
                while(!index.isEmpty() && (j==matrix[i].length || sum[index.peek()[1]] > sum[j]) ){
                    int height=sum[index.peek()[1]];
                    int width=j-index.peek()[0];
                    maxArea=Math.max(maxArea, height*width);

                    //we need to change the left most index from i as the cols which have greater height  than the curr one
                    //also contains the area of the curr col
                    temp=index.pop()[0];
                }

                int arr[]={temp,j};
                index.push(arr);
            }
        }
        return maxArea;
    }
}
