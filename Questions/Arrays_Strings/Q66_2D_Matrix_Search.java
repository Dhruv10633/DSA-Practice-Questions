// https://leetcode.com/problems/search-a-2d-matrix/description/
package Arrays_Strings;

class Solution {
    public boolean searchMatrix(int[][] matrix, int targ) {
        int j = matrix[0].length-1, i = 0;

		while(i<matrix.length && j>=0){
			if(matrix[i][j]==targ){
				return true;
			}
			else if(matrix[i][j]>targ){
				j--;
			}
			else{
				i++;
			}
		}
		return false;
    }
}
