//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
package Binary_Trees;
import java.util.*;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode targ, int k) {
        List<Integer> ans=new ArrayList<>();
        
        List<TreeNode> path=new ArrayList<>();
        pathTillTarg(root,targ,path);
        

        for(int i=0;i<path.size() && k-i>=0 ;i++){
            //From each node in the path we check if there is any node at k dist from targ node
            nodesAtK(path.get(i),k-i, (i-1>=0)? path.get(i-1):null ,ans);
        }

        return ans;
    }

    private boolean pathTillTarg(TreeNode root,TreeNode targ, List<TreeNode> path){
        if(root==null){
            return false;
        }

        if(root==targ){
            path.add(root);
            return true;
        }
        // checks first on left side of node
        if(pathTillTarg(root.left,targ,path)){
            path.add(root);
            return true;
        } 
        // if not found then goes to right
        if(pathTillTarg(root.right,targ,path)){
            path.add(root);
            return true;
        }
        return false;
       
    }

    private void nodesAtK(TreeNode node,int k,TreeNode checked,List<Integer> ans){
        if(node==null || node==checked || k<0){
            return;
        }
        
        if(k==0){
            ans.add(node.val);
            return;
        }
        k--;
        nodesAtK(node.left,k,checked,ans);
        nodesAtK(node.right,k,checked,ans);
    }
}