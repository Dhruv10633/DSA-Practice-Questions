//https://leetcode.com/problems/shortest-path-with-alternating-colors/description/
package Questions.Graphs;
import java.util.*;

class Solution {
    private class pair{
        int vert;
        char prev;
        pair(char p, int v){
            vert=v;
            prev=p;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int ans[]=new int[n];
        Arrays.fill(ans,-1);

        HashMap<Integer,HashSet<Character>> vis=new HashMap<>();

        HashMap<Integer,HashMap<Integer,Character>> paths = new HashMap<>();

        //Red-r, Blue-b, Both-n;

        //////////////////////////// This is used for Making Graph//////////// 

        for(int i=0;i<redEdges.length;i++){
            
            if(!paths.containsKey(redEdges[i][0])){
                HashMap<Integer,Character> map =new HashMap<>();
                map.put(redEdges[i][1],'r');
                paths.put(redEdges[i][0], map);
            }
            else{
                paths.get(redEdges[i][0]).put(redEdges[i][1],'r');
            }
        } 

        for(int i=0;i<blueEdges.length;i++){

            HashMap<Integer,Character> map;
            if(!paths.containsKey(blueEdges[i][0])){
                map = new HashMap<>();
                map.put(blueEdges[i][1],'b');
                paths.put(blueEdges[i][0], map);
            }
            else{
                map = paths.get(blueEdges[i][0]);
                if(map.containsKey(blueEdges[i][1])){
                    map.put(blueEdges[i][1],'n');
                }
                else{
                    map.put(blueEdges[i][1],'b');
                }
            }
        }
        //////////////////////////////////////////////////////////////////////

        /////////////////////BFS on Graph/////////////////////////

        //Pair stores Vertex and the edge colour through which it is connected
        LinkedList<pair> q=new LinkedList<>();
        q.addLast(new pair('n', 0));
        
        //initial dist =0, size=1 (after adding 0 in 'q')
        int dist=0, s=1;
        
        while(!q.isEmpty()){
            pair temp = q.removeFirst();
            s--;

            if(ans[temp.vert] == -1) ans[temp.vert]=dist;

            //this condition checks for 'n' types of edges as the can be wither 'r','b' so we need to do them twice
            //this works if either 'vis' HashMap doesn't have that vertex at all or if it does have then that particular route has not been used (could be 'r'/'b') 
            if( !vis.containsKey(temp.vert) || ( vis.containsKey(temp.vert) && !vis.get(temp.vert).contains(temp.prev) ) ) {
                
                HashSet<Character> set;
                if(!vis.containsKey(temp.vert)){
                    set = new HashSet<>();
                    set.add(temp.prev);
                    vis.put(temp.vert, set);
                }
                else{
                    set = vis.get(temp.vert);
                    set.add(temp.prev);
                }

                HashMap<Integer,Character> mp= paths.get(temp.vert);
                if(mp != null){
                    for(int x : mp.keySet()){
                        //eg if 1-2=b && 2-3=b then we continue
                        // but in case of 'n' we do not as it can be either 'r' or 'b' 
                        if(mp.get(x)!='n' && mp.get(x) == temp.prev) {
                            continue;
                        }

                        else{
                            //here the next edge can be any color/the default colour of the next vertex works
                            if(temp.prev=='n') q.addLast(new pair(mp.get(x) ,x));

                            //if the edge connecting curr vertex and the next vertex has to be the opp
                            else if(temp.prev=='r') q.addLast(new pair('b' ,x));

                            //same as above
                            else q.addLast(new pair('r' ,x));
                        }
                    }
                }
            }  

            //if all the vertices on the same level are done
            if(s==0){
                s=q.size();
                dist++;
            }
        }

        // System.out.println(paths);

        return ans;
    }
}
