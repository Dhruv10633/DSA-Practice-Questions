// https://leetcode.com/problems/minimum-falling-path-sum/description/
package Questions.DP;

public class Q2_Min_falling_path {
    public int minFallingPathSum(int[][] arr) {

        //We can do this 2 ways:
        //1.Create DP matrix and initialize the 1st row same to same ,
        //  then go to 2nd row and check if it can check upwards straight or diagnolly
        //  and among all those find the min one and add it the element of that 2 nd row
        //  and do the same for row 3.

        //2. we can actually do this without DP table but we would be modifying the actual matrix table her 

        int n = arr.length;
        int temp_min = Integer.MAX_VALUE;
        // 1st row just leave as it is for 2nd method 
        // (For 1st one u need to copy the 1st row to new Dp 2D array)
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

                temp_min = Integer.MAX_VALUE;
                //checking strt above
                temp_min = Math.min(temp_min, arr[i-1][j]);

                //Left upper Diagnol
                if (j-1>=0) temp_min = Math.min(temp_min, arr[i-1][j-1]);

                //Right upper Diagnol
                if (j+1 < n) temp_min = Math.min(temp_min, arr[i-1][j+1]);      

                arr[i][j]+=temp_min;     
            }
        }

        // after traversing the matrix the last row will have sum of aal the min paths possible for
        // each last row element and we find the min. one from them
        temp_min=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            temp_min=Math.min(temp_min, arr[n-1][j]);
        }
        return  temp_min;
    }
}
