package Topics.T14_Graphs;
// package Topics.T15_Graphs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/* 
    Graph is a set of fiite vertices and edges

    used in most of the social networking sites

    Types:
    1. Undirected - no directions given.
    2. Directed - directions are given from each node to another
    3. Connected - if all vertices are connected to each other in some way
    4. Disconnected - 

    UNDIRECTED:
    1. Weighted: some values are given for the edges of the graph

    2. Unweighted: no values are given for the edges

    Storing Graph methods:
    1. Adjacency Matrix : For Worst case each edge can be connected all other edges of the graph
                          nxn matrix for n nodes
    
    2. Adjacency List : list of n length with all nodes and their paths to all adjacent nodes (TC is very high O(N))
    
    3. Hash Map : Map of vertices as keys and their neighbour addresses as 
*/
class Graph{
    HashMap<Integer, HashMap<Integer, Integer>> map;

    Graph(int x){
        map=new HashMap<>();
        for(int i=0 ; i<x ;i++){
            map.put(i+1, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int cost){
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public boolean hasVertex(int v){
        return map.containsKey(v);
    }

    //asumming these 2 vertices exist
    public boolean hasEdge(int v1, int v2) {
        return map.get(v1).containsKey(v2);
    }

    public int noOfEdges(){
        int size=0;
        for(int key:map.keySet()){
            size += map.get(key).size();
        }
        //because the vertices are counted 2 vertices connected store each other's address
        return size/2;
    }

    public void removeVertex(int v) {
        //going to all the adjacent values from v and deleting v from there
        for(int x: map.get(v).keySet()){
            map.get(x).remove(v);
        }
        //deleting v itself
        map.remove(v);
    }

    public void removeEdge(int v1, int v2) {
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }

    public void display(){
        for(int key : map.keySet()){
            System.out.println(key+" -> "+map.get(key));
        }
    }
    

    //Path Exists
    //NEVER ASSIGN ANY VAL IN GLOBAL
    HashSet<Integer> visited=new HashSet<>();

    public boolean hasPathDFS(int src, int dest){
        if(src==dest){
            return true;
        }
        
        //we visit this vertex
        visited.add(src);

        for(int key : map.get(src).keySet()){
            //if node not visited (imp as 2 nodes connected )
            if(!visited.contains(key)){
                boolean ans = hasPathDFS(key, dest);
                if(ans) return true;
            }
        }
        //needed if we need multiple
        // visited.remove(src);

        return false;
    }
    

    //Print All Paths (DFS)
    HashSet<Integer> vis = new HashSet<>();
    public void displayPaths(int src, int dest ,String path){
        if(src==dest){
            path += " "+dest;
            System.out.println(path);
            return ;
        }
        
        //we visit this vertex
        vis.add(src);

        for(int key : map.get(src).keySet()){
            //if node not visited (imp as 2 nodes connected )
            if(!vis.contains(key)){
                displayPaths(key, dest, path +" "+src);
            }
        }
        //need to remove visited if we want to check all paths
        vis.remove(src);
    }

    //BFS (Search)
    //Steps for BFS:
    //1. remove : from top of Q
    //2. Ignore : if visited (if this condition works then a cycle exists in graph)
    //3. Visited: mark the key visited
    //4. Work   : print/adding to ll etc
    //5. Add Neighbour : adding all the neighbours (to keep a check not visit again step 2 does that)
    public boolean hasPathBFS(int src, int dest) {
        HashSet<Integer> vis = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();

        q.addFirst(src);
        while(!q.isEmpty()){
            //remove
            int x=q.removeFirst();
            //ignore
            if(vis.contains(x)){ //if this works cycle exists
                continue;
            }
            //visited mark
            vis.add(x);
            //work
            if(x==dest){
                return true;
            }
            //add neighbour
            for(int nb:map.get(x).keySet()){
                if(!vis.contains(nb)) q.addLast(nb);
            }
        }
        return false;
    }

    //DFS iterative - just replace queue with stack
    public boolean hasPathDFS_iter(int src, int dest) {
        HashSet<Integer> vis = new HashSet<>();
        Stack<Integer> st = new Stack<>();

        st.push(src);
        while(!st.isEmpty()){
            //remove
            int x=st.pop();
            //ignore
            if(vis.contains(x)){ //if this works cycle exists
                continue;
            }
            //visited mark
            vis.add(x);
            //work
            if(x==dest){
                return true;
            }
            //add neighbour
            for(int nb:map.get(x).keySet()){
                if(!vis.contains(nb)) st.push(nb);
            }
        }
        return false;
    }


    //Spanning Tree : 
    //1. It is a subset (part) of graph 
    //2. connects all vertices with min num of edges (connected graph)
    //3. no cycle
    //4. edges = vertices-1
    
    //Min Spanning Tree
    //1. same as spanning tree but with min. cost of connecting the vertices
    //2. Multiple Min Span tree, But same cost in all Min Span trees  

    //Min_Spanning Tree can be created using : 
    // 1. Bruteforce (create all spanning trees and find min)
    // 2. Greedy:  (use local min cost to find globl min cost )
    //     a. Kruskal - findingthe min
    //     b. Prims

    //Prims Algo
    public int MinSpanTree(int src) {
        int cost=0;
        HashSet<Integer> vis = new HashSet<>();
        // PriorityQueue<int[] > pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));

        //in arr 0-source, 1-dest, 2-cost
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[2]-b[2];
            }
        });

        pq.add(new int[]{src,src,0});
        while(!pq.isEmpty()){
            //remove
            int [] x=pq.remove();
            //ignore as we dont add already visited edges 
            if(vis.contains(x[1])){ //if this works cycle exists
                continue;
            }
            //visited mark
            vis.add(x[1]);
            //work
            System.out.println(x[0]+" "+x[1]+" cost: "+x[2]);
            cost+=x[2];
            //add neighbour
            for(int nb:map.get(x[1]).keySet()){
                //cond. optional just helps skips a few steps
                if(!vis.contains(nb)) pq.add(new int[]{x[1], nb, map.get(x[1]).get(nb)});
            }
        }
        return cost;
    }
}

public class Graphs {
    
    
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(1,2,5);
        g.addEdge(1, 3, 6);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 3);
        g.addEdge(3, 4, 3);
        g.addEdge(6, 7, 4);
        g.addEdge(5, 6, 2);
        g.addEdge(5, 7, 5);

        g.display();
        // System.out.println(g.noOfEdges());
        // g.removeEdge(2, 5);
        // System.out.println(g.noOfEdges());
        // g.display();

        //PATH PRESENT
        System.out.println(g.hasPathDFS(7, 1));
        System.out.println(g.hasPathBFS(7, 1));

        System.out.println();

        //Min Spanning Tree
        System.out.println(g.MinSpanTree(1));


    }
}
