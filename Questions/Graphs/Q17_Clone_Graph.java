// https://leetcode.com/problems/clone-graph/description/
package Graphs;
import java.util.*;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {
    public Node cloneGraph(Node node) {
        return dfs(node, new Node[101]);
    }

    
    public Node dfs(Node node, Node[] vis){
        if(node==null) return null;

        Node newN = new Node(node.val);

        vis[node.val] = newN;

        
        for(Node x: node.neighbors){
            //if present in vis
            if(vis[x.val]==null){
                Node clone = dfs(x, vis);
                newN.neighbors.add(clone);
            }
            //if not present
            else{
                newN.neighbors.add(vis[x.val]);
            }
        }
        return newN;
        
    }
}
