// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
package Binary_Trees;


public class Q7_Max_Prod_after_tree_split {

    private long maxProd=0;
    
    public int maxProduct(TreeNode root) {
        int sum = DFSsum(root);
        maxSplittedProd(root,sum);

        return (int)(maxProd % 1000000007);
    }

    private int DFSsum(TreeNode root){
        if(root==null){
            return 0;
        }

        return root.val + DFSsum(root.left) +DFSsum(root.right);   
    }

    
    private int maxSplittedProd(TreeNode root,long sum){
        if(root==null){
            return 0;
        }

        int currSum= root.val + maxSplittedProd(root.left,sum) + maxSplittedProd(root.right,sum);
        maxProd=Math.max(maxProd, (currSum)*(sum-currSum));
        return currSum;
    }
}
