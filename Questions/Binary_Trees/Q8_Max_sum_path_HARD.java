//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
package Binary_Trees;

public class Q8_Max_sum_path_HARD {
    private int maxS=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root); 
        return maxS;
    }

    //Post order traversal Sum
    private int maxSum(TreeNode root){
        if(root==null){
            return 0;
        }

        //Here we take max so as to elininate the -ve left and right subtree
        //Also since we dont need the entire path even a small sub path is alright
        int l=Math.max(0,maxSum(root.left));
        int r=Math.max(0,maxSum(root.right));

        maxS = Math.max(maxS, (l+r+root.val));
        
        return Math.max(l,r)+root.val;

    }


    // Method 2 - own method

    // private int maxSum(TreeNode root){
    //     if(root==null){
    //         //Dont send Integer.MIN_VALUE as even a small -1 to it could overflow the integer
    //         return -1001;
    //     }

    //     int l=maxSum(root.left);
    //     int r=maxSum(root.right);

    //     //checking if entire sub tree max value
    //     maxS = Math.max(maxS, (l+r+root.val));
    //     //checking if only l+root tree is max
    //     maxS = Math.max(maxS, (l+root.val));
    //     //checking if only r+root tree is max
    //     maxS = Math.max(maxS, (r+root.val));
    //     //checking if only l subtree max
    //     maxS = Math.max(maxS, (l));
    //     //checking if only r rubtree max
    //     maxS = Math.max(maxS, (r));
    //     //checking if only root val is the max (i.e all left and right subtrees are providing -ve or lesser val than root) 
    //     maxS = Math.max(maxS, (root.val));
        
    //     //then sending the (left or right subtree with root node //because only 1 path) or just the (root node)
    //     return Math.max(root.val, Math.max(l,r)+root.val);

    // }
}
