// https://practice.geeksforgeeks.org/problems/topological-sort/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
package Graphs;
import java.util.*;

//Linear Ordering of vertices such that for every edge u->v
//u appears before v;

//Works only on DAG(Directed Acyclic Graph)

class Solution
{
    //Function to return list containing vertices in Topological order. 
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        // System.out.println(V);
        int[] ans = new int[V];
        HashSet<Integer> vis = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        
        //for disjoint graph components
        for(int i=0;i<V;i++){
            if(!vis.contains(i)){
                DFS(i, adj, vis, st);
            }
        }
        
        int i=0;
        
        while(!st.isEmpty() ){
            ans[i++] = st.pop();
        }
        
        return ans;
    }
    
    private static void DFS(int x, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> vis, Stack<Integer> st){
        vis.add(x);
        
        for(int nb:adj.get(x)){
            if(!vis.contains(nb)) DFS(nb, adj, vis, st);
        }
        
        st.push(x);
    }
}