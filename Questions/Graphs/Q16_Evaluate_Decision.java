// https://www.codingninjas.com/codestudio/problems/evaluate-division_1082456?leftPanelTab=0
package Graphs;
import java.util.*;

class Solution {
    public static ArrayList<Double> evaluateEquations(ArrayList<ArrayList<String>> eq, ArrayList<ArrayList<String>>  queries, ArrayList<Double> values) {
        // Write your code here.
        
        ArrayList<Double> ans = new ArrayList<>();

        HashMap<String, HashMap<String, Double>> map = createMap(eq, values);

        for(ArrayList<String> q : queries){
            String s = q.get(0);
            String d = q.get(1);

            if(!map.containsKey(s) || !map.containsKey(d)) ans.add((double)-1);
            else ans.add(division(map, s, d, new HashSet<String>()));
        }

        return ans;
    }


    private static double division(HashMap<String, HashMap<String, Double>> map, String s, String d, HashSet<String> vis){
        double ans = -1;
        
        if(s.equals(d)){
            // System.out.println("Found!");
            return 1;
        }

        vis.add(s);

        // System.out.print(s+"->");
        
        for(String key : map.get(s).keySet()){
            if(!vis.contains(key)){
                double temp = division(map, key, d, vis);
                if(temp!=ans){
                    return temp * map.get(s).get(key);
                }
            }
        }

        // System.out.println();
        vis.remove(s);

        return ans;


    }


    private static HashMap<String, HashMap<String, Double>> createMap(ArrayList<ArrayList<String>> eq, ArrayList<Double> values){
        
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();

        for(int i=0;i<eq.size();i++){
            String p1 = eq.get(i).get(0);
            String p2 = eq.get(i).get(1);
            Double val = values.get(i);

            HashMap<String, Double> temp;

            if(map.containsKey(p1)){
                temp = map.get(p1);
                temp.put(p2, val);
                
            }
            else{
               temp = new HashMap<>(); 
               temp.put(p2, val);
               map.put(p1, temp);
            }

            if(map.containsKey(p2)){
                temp = map.get(p2);
                temp.put(p1, 1/val);
                
            }
            else{
               temp = new HashMap<>(); 
               temp.put(p1, 1/val);
               map.put(p2, temp);
            }
        }

        // for(String x:map.keySet()){
        //     System.out.print(x+" -> ");

        //     HashMap<String, Double> temp = map.get(x);

        //     for(String s: temp.keySet()){
        //         System.out.print(s+"-"+temp.get(s)+", ");
        //     }
        //     System.out.println();
        // }

        return map;
    }
}