//https://leetcode.com/problems/unique-paths-iii/description/
package Recursion_Backtracking;

class Solution {
    private int paths=0;

    public int uniquePathsIII(int[][] grid) {
        int si=0,sj=0,total=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    si=i;
                    sj=j;
                    //we do this to make it easier for calculation
                    grid[i][j]=0;
                }
                //all blocks including the end and start, excluding the obstacles are added
                if(grid[i][j]!=-1){
                    total++;
                }
            }
        }
        uniquePaths(grid,si,sj,total);
        // System.out.print(si+","+sj+" "+total);
        return paths;
    }

    private void uniquePaths(int[][] grid,int si,int sj,int total){
        if(grid[si][sj]==2){
            // total -1 to also count the final dest.
            if(total-1==0){
                paths++;
            }
            return;
        }

        //check if the block has not been traversed
        if(grid[si][sj]==0){
            //we have included it in path
            grid[si][sj]=1;

            //check if up block is blocked/traversed
            if(si-1>=0 && grid[si-1][sj]!=1 && grid[si-1][sj]!=-1){
                uniquePaths(grid,si-1,sj,total-1);
            }
            //down
            if(si+1<grid.length && grid[si+1][sj]!=1 && grid[si+1][sj]!=-1){
                uniquePaths(grid,si+1,sj,total-1);
            }
            //left
            if(sj-1>=0 && grid[si][sj-1]!=1 && grid[si][sj-1]!=-1){
                uniquePaths(grid,si,sj-1,total-1);
            }
            //right
            if(sj+1<grid[0].length && grid[si][sj+1]!=1 && grid[si][sj+1]!=-1){
                uniquePaths(grid,si,sj+1,total-1);
            }
            //if we cant go any where from that block and also it is not the final.dest
            //so we backtrack i.e. we remove this block from our ongoing part and return to our earlier block
            grid[si][sj]=0;
        }
        return;

    }
}