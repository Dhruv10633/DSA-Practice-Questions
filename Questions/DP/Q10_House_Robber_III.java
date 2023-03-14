//https://leetcode.com/problems/house-robber-iii/description/
package Questions.DP;
import java.util.*;


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
 
class Solution {
    private HashMap<TreeNode,Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;

        if(map.containsKey(root)) return map.get(root);

        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        //we take the root val and the sum of other grandchildren nodes(next to next level) or,
        //or the sum of the left and right subtrees
        map.put(root, Math.max(val + root.val, rob(root.left) + rob(root.right)));
        
        return map.get(root);
    }
}
