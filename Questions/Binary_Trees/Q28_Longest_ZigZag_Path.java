// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
package Binary_Trees;

class Solution {
    public int longestZigZag(TreeNode root) {
        int[] ans = new int[1];

        solve(root, ' ', ans);

        return ans[0];
    }

    private int solve(TreeNode root, char lastDir, int[] ans){
        if(root==null){
            return 0;
        }

        int left = 1 + solve(root.left, 'l', ans);
        int right = 1 + solve(root.right, 'r', ans);

        ans[0] = Math.max(ans[0], Math.max(left-1, right-1));

        if(lastDir == 'l') return right;
        if(lastDir == 'r') return left;
        return Math.max(left, right);
    }
}
