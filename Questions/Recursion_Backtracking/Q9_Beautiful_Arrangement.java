//https://leetcode.com/problems/beautiful-arrangement/description/
package Recursion_Backtracking;

class Solution {
    public int countArrangement(int n) {
        
        return arrangements(1,n,new boolean[n+1]);
    }

    private int arrangements(int i,int n,boolean visited[]){
        int cnt=0;

        if(i>n){
            return 1;
        }

        for(int j=1;j<=n;j++){

            //here visited[j] ==  false checks if the number has been used earlier
            if((i%j==0 || j%i==0) && visited[j]==false){
                visited[j]=true;
                cnt+=arrangements(i+1,n,visited);
                visited[j]=false;
            }
        }
        return cnt;
    }
}
