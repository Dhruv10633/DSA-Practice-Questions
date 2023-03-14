package BST;

public class Q4_Check_Symmetry {
    public boolean isSymmetric(TreeNode root) {
        return isSym(root.left,root.right);
    }

    private boolean isSym(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }

        if(!isSym(root1.left,root2.right)) return false;
        if(!isSym(root1.right,root2.left)) return false;

        return true;

    }
}
