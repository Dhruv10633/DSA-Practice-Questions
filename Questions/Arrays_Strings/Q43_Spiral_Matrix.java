//https://leetcode.com/problems/spiral-matrix/
package Arrays_Strings;
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();

        int l=0,t=0;
        int r=matrix[0].length-1;
        int b=matrix.length-1;
        int size= (r+1)*(b+1);

        int count=0;

        while(count < size){
            for(int i=l;i<=r && count < size;i++){
                ans.add(matrix[t][i]);
                count++;
            }
            t++;
            for(int i=t;i<=b && count < size;i++){
                ans.add(matrix[i][r]);
                count++;
            }
            r--;
            for(int i=r;i>=l && count < size;i--){
                ans.add(matrix[b][i]);
                count++;
            }
            b--;
            for(int i=b;i>=t && count < size;i--){
                ans.add(matrix[i][l]);
                count++;
            }
            l++;
        }

        return ans;
    }
}
