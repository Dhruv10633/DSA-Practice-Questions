//https://leetcode.com/problems/diameter-of-binary-tree/
package Binary_Trees;

public class Q5_Diameter_Of_Binary_tree {
    //Unoptimised
    // public int diameterOfBinaryTree(TreeNode root) {
    //     if(root==null) return 0;
        
    //     int d=ht(root.left)+ht(root.right);
    //     //TC n^2 as we traverse the entire tree n times for each node
    //     int l=diameterOfBinaryTree(root.left)+1;
    //     int r=diameterOfBinaryTree(root.right)+1;
    //     return Math.max(d,Math.max(l,r));
    // }
    
    // public int ht(TreeNode root) {
    //     if(root==null) return -1;
        
    //     int l=ht(root.left);
    //     int r=ht(root.right);

    //     return Math.max(l,r)+1;
    // }
    /////////////////////////////////////////////

    //Optimised
    private int fin=0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return fin;
    }

    private int diameter(TreeNode root){
        if(root==null){
            return -1;
        }
        int l = diameter(root.left)+1;
        int r = diameter(root.right)+1;

        //storing diam at eac node(l+r) in fin if > fin
        fin=Math.max(fin,l+r);

        //returning the max l,r branch to check the diam in upper nodes (not l+r)
        return Math.max(l, r);
    }

}
