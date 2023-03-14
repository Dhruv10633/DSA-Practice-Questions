//https://leetcode.com/problems/binary-tree-right-side-view/

package Binary_Trees;
import java.util.*;

public class Q11_Bin_tree_right_view {

    //Level Order Approach
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans= new ArrayList<>();
        if(root==null) return ans;
        List<TreeNode> q=new ArrayList<>();

        q.add(root);
        int l=1;

        while(q.size()!=0){
            l--;
            TreeNode temp=q.remove(0);
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);

            //when we reach l==0 we mean that we are end of that level
            if(l==0){
                ans.add(temp.val);
                l=q.size();
            }
        }

        return ans;
    }

    //Depth First Search


}
