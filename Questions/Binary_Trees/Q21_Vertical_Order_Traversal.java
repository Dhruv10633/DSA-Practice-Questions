//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/

package Binary_Trees;
import java.util.*;

class Solution {

    private class pair{
        TreeNode node;
        int col;
        pair(TreeNode node,int col){
            this.node=node;
            this.col=col;
        }
    } 

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();

        //pair LinkedList for keeping track of the col number
        LinkedList<pair> q=new LinkedList<>();

        //Treemap which takes col number and another treemap
        //the other treemap(because in vert we go from up to down) consists of each level and minHeap for each level 
        //(we need all the elements in the same vertical and at same level to be sorted);
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> vert=new TreeMap<>();

        int s=1,l=1;
        q.addFirst(new pair(root,0));

        while(!q.isEmpty()){
            s--;

            pair temp=q.removeFirst();
            
            //check if col num already in map
            if(vert.containsKey(temp.col)){

                //tmap corresponding to that col number
                TreeMap<Integer,PriorityQueue<Integer>> lt=vert.get(temp.col);

                PriorityQueue<Integer> minH;

                //check if the minheap for the level exists
                if(lt.get(l) != null){
                    minH=lt.get(l);
                }
                else{
                    minH=new PriorityQueue<>();
                }
                
                minH.add(temp.node.val);
                lt.put(l,minH);
                
            }

            //if the col num is entering for the 1st time
            else{
                TreeMap<Integer,PriorityQueue<Integer>> lt=new TreeMap<>();
                PriorityQueue<Integer> minH=new PriorityQueue<>();
                minH.add(temp.node.val);
                lt.put(l,minH);
                vert.put(temp.col, lt);
            }

            if(temp.node.left!=null) q.addLast(new pair(temp.node.left,temp.col-1));
            if(temp.node.right!=null) q.addLast(new pair(temp.node.right,temp.col+1));

            if(s==0){
                l++;
                s=q.size();
            }
        }

        //just adding the treemap values to final 2D
        for(int x : vert.keySet()){

            TreeMap<Integer,PriorityQueue<Integer>> lt=vert.get(x);
            List<Integer> a=new ArrayList<>();
            
            for(int level: lt.keySet()){
                PriorityQueue<Integer> minH=lt.get(level);

                while(!minH.isEmpty()){
                    a.add(minH.remove());
                }
            }

            ans.add(a);
            
        }
        return ans;
    }
}

