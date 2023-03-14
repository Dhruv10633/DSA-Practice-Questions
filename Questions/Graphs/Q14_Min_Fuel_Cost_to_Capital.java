//https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/
package Graphs;
import java.util.*;

class Solution {
    
    public long minimumFuelCost(int[][] roads, int seats) {
        //if no interconnecting roads
        if(roads.length==0) return 0l;

        //create a graph for the given roads
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>(roads.length);

        for (int i = 0; i < roads.length + 1; i++) graph.add(new ArrayList<Integer>());

        for(int i=0;i<roads.length;i++){
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        
        long[] arr = minCost(graph,(long)seats,0,new HashSet<Integer>());

        return arr[0];
    }


    //here we use an array or we can create a custom class eg pair as we need to keep track of 2 values
    private long[] minCost(ArrayList<ArrayList<Integer>> graph, long seats, int i, HashSet<Integer> vis){
        long cost=0, people=0;
        
        vis.add(i);
        for(int x : graph.get(i)){
            if(vis.contains(x)) continue;

            long arr[]= minCost(graph,seats,x,vis);

            //to keep track of the total people
            people += arr[1];

            //'p' here is the number of people till the last point
            long p = arr[1];

            //cost of all negihbouring paths from this vertex
            //'arr[0]' is costs till last point and  'p/seats' is the cost from that last to curr point
            cost += arr[0] + p/seats;
            //if there are some people left then they need to travel in another car adding to cost
            //eg for 5 people and car with seats=3, then we need 5/3 + 1 = 2 cars;
            if(p % seats != 0){
                cost ++;
            }
        }
        vis.remove(i);   //not needed (u can remove no prob)

        return new long[]{cost,people+1};
    }
}
