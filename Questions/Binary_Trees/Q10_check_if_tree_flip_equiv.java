//https://leetcode.com/problems/flip-equivalent-binary-trees/description/
package Binary_Trees;

public class Q10_check_if_tree_flip_equiv {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //if we reach the end nodes of both the tree at same time
        if(root1==null && root2==null){
            return  true;
        }
        //if we dont reach the null of both trees then trees aren't flip equiv
        if(root1==null || root2==null){
            return false;
        }
        
        if(root1.val!=root2.val) {
            return false;
        }
        
        // checking without flipping
        boolean x=flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        // Checking with flipping
        boolean y=flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

        return x||y;

    }
}
