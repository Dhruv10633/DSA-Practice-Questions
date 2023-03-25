//https://leetcode.com/problems/unique-paths-iii/description/
package Recursion_Backtracking;

class Solution {

    public int uniquePathsIII(int[][] grid) {
        int si=0,sj=0,obs=0,total=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    si=i;
                    sj=j;
                    //we do this to make it easier for calculation
                    grid[i][j]=0;
                }
                //all blocks including the end and start, excluding the obstacles are added
                else if(grid[i][j]!=-1){
                    total++;
                }
            }
        }
        return uniquePaths(grid,si,sj,total);
    }

    private int uniquePaths(int[][] grid,int si,int sj,int total){
        if(grid[si][sj]==2){
            if(total==0){
                return 1;
            }
            else return 0;
        }

        int paths = 0;
        //check if the block has not been traversed
        if(grid[si][sj]==0){
            //we have included it in path
            grid[si][sj]=1;

            //check if up block is blocked/traversed
            if(si-1>=0 && grid[si-1][sj]!=1 && grid[si-1][sj]!=-1){
                paths += uniquePaths(grid,si-1,sj,total-1);
            }
            //down
            if(si+1<grid.length && grid[si+1][sj]!=1 && grid[si+1][sj]!=-1){
                paths += uniquePaths(grid,si+1,sj,total-1);
            }
            //left
            if(sj-1>=0 && grid[si][sj-1]!=1 && grid[si][sj-1]!=-1){
                paths += uniquePaths(grid,si,sj-1,total-1);
            }
            //right
            if(sj+1<grid[0].length && grid[si][sj+1]!=1 && grid[si][sj+1]!=-1){
                paths += uniquePaths(grid,si,sj+1,total-1);
            }
            //if we cant go any where from that block and also it is not the final.dest
            //so we backtrack i.e. we remove this block from our ongoing part and return to our earlier block
            grid[si][sj]=0;
        }
        return paths;
    }
}