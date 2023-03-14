//https://leetcode.com/problems/n-queens/
package Recursion_Backtracking;
import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {
        return nQueens(0,0,n,n,new boolean[n][n]);       
    }

    private List<List<String>> nQueens(int r,int c,int n,int tq,boolean visited [][]){
        List<List<String>> res=new ArrayList<>();

        if(tq==0 || r==n){
            List<String> list=new ArrayList<>();
            fill(list,visited);
            res.add(list);
            return res;
        }
        
        if(c==n){
            return res;
        }
        if(check(r,c,n,visited)){
            visited[r][c]=true;

            List<List<String>> ll=nQueens(r+1,0,n,tq-1,visited);
            for(List<String> l:ll){
                res.add(l);
            }
            visited[r][c]=false;
        }

        //no else otherwise it would never move
        List<List<String>> ll=nQueens(r,c+1,n,tq,visited);
        for(List<String> l:ll){
            res.add(l);
        }

        return res;
    }

    private boolean check(int r,int c,int n,boolean visited [][]){
        //check above
        for(int i=0;i<r;i++){
            if(visited[i][c]){
                return false;
            }
        }
        //Check left upper diag
        for(int i=r,j=c; i>=0 && j>=0 ;i--,j--){
            if(visited[i][j]){
                return false;
            }
        }
        //check right upper diag
        for(int i=r,j=c; i>=0 && j<n ;i-- ,j++){
            if(visited[i][j]){
                return false;
            }
        }
        return true;
    }


    private void fill(List<String> list,boolean visited[][]){
        for(int i=0;i<visited.length;i++){
            String s="";
            for(int j=0;j<visited.length;j++){
                if(visited[i][j]){
                    s+='Q';
                }
                else{
                    s+='.';
                }
            }
            list.add(s);
        }
    }
}
