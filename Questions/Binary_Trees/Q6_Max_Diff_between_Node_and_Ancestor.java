// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
package Binary_Trees;

public class Q6_Max_Diff_between_Node_and_Ancestor {
    // private int maxDiff=0;

    // public int maxAncestorDiff(TreeNode root) {
    //     maxMin(root,Integer.MAX_VALUE,-1);

    //     return maxDiff;
    // }

    // private void maxMin(TreeNode root,int min ,int max){
    //     if(root==null){
    //         return;
    //     }
    //     max=Math.max(max,root.val);
    //     min=Math.min(min,root.val);
        

    //     maxMin(root.left,min,max);
    //     maxMin(root.right,min,max);

    //     maxDiff=Math.max(Math.abs(max-min),maxDiff);
    //     return;

    // }

    ///////Better:

    public int maxAncestorDiff(TreeNode root) {
        return maxMin(root,Integer.MAX_VALUE,-1,0);
    }

    private int maxMin(TreeNode root,int min ,int max,int maxDiff){
        if(root==null){
            return maxDiff;
        }
        max=Math.max(max,root.val);
        min=Math.min(min,root.val);
        
        maxDiff= max-min;
        return Math.max(maxMin(root.left,min,max,maxDiff) , maxMin(root.right,min,max,maxDiff));

    }
}
