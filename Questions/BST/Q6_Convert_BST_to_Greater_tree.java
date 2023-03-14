// https://leetcode.com/problems/convert-bst-to-greater-tree/description/
package BST;

class Solution {

    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    private int sum=0;
    private void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.right);
        sum+=root.val;
        root.val=sum;
        inOrder(root.left);
    }
}
