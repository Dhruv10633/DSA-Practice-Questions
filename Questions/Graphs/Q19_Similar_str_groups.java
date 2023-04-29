// https://leetcode.com/problems/similar-string-groups/description/
package Graphs;

class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;

        int[][] map = new int[n][n]; 

        //We basically create a map denoting which string is similar to whhich
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (areSimilar(strs[i], strs[j])) {
                    map[i][j]=map[j][i]=1;
                }
            }
        }

        //Then we do DFS on that map for each string
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(strs[i].equals("")){
                continue;
            }
            else{
                dfs(strs, map, i);
                count++;
            }
        }

        return count;
    }


    private void dfs(String[] strs, int[][] map, int i){
        if(strs[i].equals("")) return;

        //To make sure we don't traverse it again
        strs[i]="";

        for(int j=0; j < map[i].length; j++){
            if(map[i][j]==1){
                dfs(strs, map, j);
            }
        }
    }

    
    private boolean areSimilar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 2) {
                    return false;
                }
            }
        }
        return diff == 2 || diff == 0;
    }
    
    
}
