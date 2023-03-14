// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
package Binary_Trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Q2_root_to_path_sum {

    public static int sumNumbers(TreeNode root) {

        return sumNumbers( root,0);
    }

    private static int sumNumbers(TreeNode root,int num) {
        //here we need to return 0 not the num itself
        //because if in case we get to a node 4 which has one leaf node 5
        //it will give 2 nums ..45 also ..4(should have been 0 as 4 not a leaf node)which is wrong
        if(root==null){
            return 0;
        }

        //here we return the num
        num=num*10 + root.val;
        if(root.left==null && root.right==null){
            return num;
        }
        
        return sumNumbers(root.left, num) + sumNumbers(root.right, num);
        

    }


}
