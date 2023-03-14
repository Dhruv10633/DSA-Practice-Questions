
package BST;
class TreeNode{
    int val=0;
    TreeNode left=null;
    TreeNode right=null;

    TreeNode(int val){
        this.val=val;
    }
}

public class Q1_Insert_a_Node {
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){ 
            return new TreeNode(val);
        }


        if(val>root.val){
            // this when calling back after reaching null
            // will assign the last "root" node from the recursive call to 
            // current "root.right"
            root.right=insertIntoBST(root.right,val);
        }
        else{
            // same as above
            root.left=insertIntoBST(root.left,val);
        }
        return root;
    }
}
