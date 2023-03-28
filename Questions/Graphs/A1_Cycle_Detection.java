// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
package Graphs;
import java.util.*;


//Undirected
class Solution1 {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        HashSet<Integer> vis = new HashSet<>();
        
        //for disjoint graph components
        for(int i=0;i<adj.size();i++){
            if(!vis.contains(i)){
                boolean check = checkCyc(i, adj, vis);
                if(check) return true;
            }
        }
        return false;
        
    }
    
    private boolean checkCyc(int v, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> vis){
        LinkedList<Integer> q = new LinkedList<>();
        
        q.addFirst(v);
        
        while(!q.isEmpty()){
            int x = q.removeFirst();
            
            if(vis.contains(x)) return true;
            else vis.add(x);
            
            for(int i:adj.get(x)){
                if(!vis.contains(i)) q.addLast(i);
            }
        }
        return false;
    }
}


//Directed
class Solution2{
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        HashSet<Integer> vis = new HashSet<>();
        HashSet<Integer> visDFS = new HashSet<>();
        
        //for disjoint graph components
        for(int i=0;i<adj.size();i++){
            if(!vis.contains(i)){
                boolean check = checkCyc(i, adj, vis, visDFS);
                if(check) return true;
            }
        }
        return false;
    }
    
    private boolean checkCyc(int x, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> vis, HashSet<Integer> visDFS){
        if(vis.contains(x)) return true;
        
        vis.add(x);
        visDFS.add(x);
        
        for(int i:adj.get(x)){
            if(!vis.contains(i)){
                if(checkCyc(i, adj, vis, visDFS)) return true;
            }
            else if(visDFS.contains(i) && vis.contains(i)){
                return true;
            }
        }
        
        visDFS.remove(x);
        return false;
    }
}
