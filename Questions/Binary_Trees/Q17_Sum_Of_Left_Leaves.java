//https://leetcode.com/problems/sum-of-left-leaves/solutions/
package Binary_Trees;
import java.util.*;

class Solution {
    //// Iterative
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        LinkedList<TreeNode> q=new LinkedList<>();

        q.addFirst(root);
        while(!q.isEmpty()){
            
            TreeNode temp=q.removeFirst();
            if(temp.left!=null){
                q.addLast(temp.left);
                if(temp.left.left==null && temp.left.right==null){
                    sum+=temp.left.val;
                }
            }
            if(temp.right!=null) q.addLast(temp.right);

            
        }
        return sum;
    }

    //// Recursive
    public int sumOfLeftLeaves2(TreeNode root) {
        int sum=0;
        if(root==null){
            return sum;
        }
        
        if(root.left!=null && root.left.left==null && root.left.right==null){
            sum+=root.left.val;
        }


        sum+=sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
        return sum;
    }

}
