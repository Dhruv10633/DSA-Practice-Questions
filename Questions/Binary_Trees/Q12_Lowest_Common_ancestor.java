// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
package Binary_Trees;

public class Q12_Lowest_Common_ancestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //unable to find p || q on that side of the tree
        if(root==null){
            return null;
        }

        //if we find the either p || q or return
        if(root==p || root==q){
            return root;
        }

        TreeNode L=lowestCommonAncestor(root.left,p,q);
        TreeNode R=lowestCommonAncestor(root.right,p,q);
        //If we find the L in left subtree and R in the right subtree
        if(L!= null && R!=null){
            return root;
        }
        
        //If we find the p || q in right subtree but p ||q is not in the left side i.e. R node is the LCA 
        else if(L==null){
            return R;
        }

        //Same as above
        else if(R==null){
            return L;
        }

        return root;
    }
}
