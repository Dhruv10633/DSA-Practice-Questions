//https://leetcode.com/problems/validate-binary-search-tree/
package BST;

public class Q3_Validate_BST {
    private class trip{
        long max=Long.MIN_VALUE;
        long min=Long.MAX_VALUE;
        boolean isBST=true;
    }
    public boolean isValidBST(TreeNode root) {
        trip ans=checker(root);

        return ans.isBST;
    }

    private trip checker(TreeNode root){
        if(root==null){
            return new trip();
        }

        trip l=checker(root.left);
        trip r=checker(root.right);

        //this is getting returned
        trip ans=new trip();

        //check if the lower left and right subtree are BST && 
        //the max number on the left side of root is < root
        //the min number on the right side of root is >root
        if(l.isBST==true && r.isBST==true && root.val>l.max && root.val<r.min){
            ans.isBST = true;
            ans.max = Math.max(root.val, Math.max(l.max,r.max));
            ans.min = Math.min(root.val, Math.min(l.min,r.min));
            return ans;
        }

        // if any above cond. fails then no BST
        // else {
            ans.isBST=false;
            return ans;
        // }

        

    }
}
