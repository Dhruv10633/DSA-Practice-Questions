// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
package Graphs;
import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adjc = new ArrayList<>();

        for(int i=0;i<n+1;i++) adjc.add(new ArrayList<int[]>());

        for(int[] arr : roads){
            List<int[]> li1 = adjc.get(arr[0]);
            List<int[]> li2 = adjc.get(arr[1]);

            li1.add(new int[]{arr[1], arr[2]});
            li2.add(new int[]{arr[0], arr[2]});
        }
        return solve(adjc, 1, n, new HashSet<>());  
    }

    private int solve(List<List<int[]>> adjc, int i, int n, HashSet<Integer> vis){
        if(i==n){
            return Integer.MAX_VALUE;
        }

        List<int[]> li = adjc.get(i-1);

        int ans = -1;

        System.out.println(li);
        for(int[] arr:li){
            System.out.print(arr[0]+" "+arr[1]+" - ");
            if(!vis.contains(arr[0])){
                ans = arr[1];
                vis.add(arr[0]);
                ans = Math.min(arr[1], solve(adjc, arr[0], n, vis));
                vis.remove(arr[0]);
            }
        }

        System.out.println();
        return ans;
    }
}

