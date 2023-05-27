import java.util.*;

public class Rough {

    public static int closedIsland(int[][] grid) {
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
                if(grid[i][j]==1){
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }


    private static void dfs(int i, int j, int[][]grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return;

        grid[i][j]=0;  

        dfs(i+1, j, grid);
        dfs(i, j+1, grid);
        dfs(i-1, j, grid);
        dfs(i, j-1, grid);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt(), n = sc.nextInt();
        
        int grid[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(closedIsland(grid));
        sc.close();
    }
}
