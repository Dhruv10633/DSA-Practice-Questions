//https://leetcode.com/problems/invert-binary-tree/description/
package Binary_Trees;
import java.util.*;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        
        return levelOrder(root);        
    }

    private TreeNode levelOrder(TreeNode root){
        LinkedList<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode temp = q.removeFirst();

            TreeNode swap = temp.left;
            temp.left = temp.right;
            temp.right = swap;

            if(temp.left!=null){
                q.addLast(temp.left);
            }
            if(temp.right!=null){
                q.addLast(temp.right);
            }
        } 

        return root;
    }   
}
