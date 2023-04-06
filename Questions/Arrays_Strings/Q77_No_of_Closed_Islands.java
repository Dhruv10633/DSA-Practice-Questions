// https://leetcode.com/problems/number-of-closed-islands/description/
package Arrays_Strings;

class Solution {
    public int closedIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            dfs(i, 0, grid);
            dfs(i, grid[0].length-1, grid);
        }

        for(int j=0;j<grid[0].length;j++){
            dfs(0, j, grid);
            dfs(grid.length-1, j, grid);
        }

        int count=0;
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }


    private void dfs(int i, int j, int[][]grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==1) return;

        grid[i][j]=1;  

        dfs(i+1, j, grid);
        dfs(i, j+1, grid);
        dfs(i-1, j, grid);
        dfs(i, j-1, grid);
    }
}
