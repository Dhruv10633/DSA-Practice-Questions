//https://leetcode.com/problems/balanced-binary-tree/description/
package Binary_Trees;

public class Q9_check_balanced {
    public boolean isBalanced(TreeNode root) {
        boolean[] bal={true};
        //boolean[] bal= new boolean[] {true};
        isBal(root,bal);
        return bal[0];
    }

    private int isBal(TreeNode root,boolean[] bal){
        if(root==null){
            return -1;
        }
        int l=isBal(root.left,bal);
        int r=isBal(root.right,bal);
            
        if(bal[0] && l-r!=0 && l-r!=-1 && l-r!=1){
            // System.out.println(root.val+" "+l+" "+r+" "+(l-r));
            bal[0]=false;
        }

        return Math.max(l,r)+1;
    }
}
