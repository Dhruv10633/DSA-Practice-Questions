// https://leetcode.com/problems/largest-color-value-in-a-directed-graph/description/
package Graphs;
import java.util.*;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i<colors.length(); i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int source = edge[0];
            int dest = edge[1];

            graph.get(source).add(dest);
        }
      
        HashSet<Integer> vis = new HashSet<>(), path = new HashSet<>();
        int[][] dp = new int[colors.length()][26];
        int ans=-1;

        for(int i=0;i<colors.length();i++){
            if(vis.contains(i)) continue;

            int temp = dfs(graph, i, colors, path, vis, dp);
            if(temp==-1) return -1;

            ans = Math.max(ans, temp);  
        }
        
        return ans;
    }


    private int dfs(List<List<Integer>> graph, int i, String colors, Set<Integer> path, Set<Integer> vis, int[][] dp){
        
        // cycle
        if(path.contains(i)){
            return -1;
        }
        if(vis.contains(i)){
            return 0;
        }

        vis.add(i);
        path.add(i);
        

        int ans = 1;
        for(int adj : graph.get(i)){
            
            int temp = dfs(graph, adj, colors, path, vis, dp);
            if(temp==-1) {
                ans = -1;
                break;
            }
            
            // while coming back from the recursiva call we know the colour frex of all the next val from curr node
            for(int k=0;k<26;k++){
                dp[i][k] = Math.max(dp[i][k], dp[adj][k]);

                temp = dp[i][k];
                if(k==colors.charAt(i)-'a') temp++; 

                ans = Math.max(ans, temp);
            }
        }

        dp[i][colors.charAt(i)-'a']++;
        path.remove(i); //dont remove from vis

        return ans;
    }
}