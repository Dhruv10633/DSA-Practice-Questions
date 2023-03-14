//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
package Binary_Trees;
import java.util.*;

public class Q13_Bin_Tree_from_pre_and_in {
    //Pre-root,left,right
    //in-left,root,right
    //post-left,right,root
    private Map<Integer,Integer> inmap=new HashMap<>();
    
    public TreeNode buildTree(int[] preor, int[] inor) {
        for(int i=0;i<inor.length;i++){
            inmap.put(inor[i],i);
        }
        return build(preor,0,preor.length-1,inor,0,inor.length-1);
    }

    private TreeNode build(int[]pre,int sp,int ep,int[]in,int si,int ei){
        if(sp>ep || si>ei){
            return null;
        }
        //root node is the 1st index of the preorder
        TreeNode root=new TreeNode(pre[sp]);

        //finding root created in inorder map
        int idx=inmap.get(pre[sp]);

        //all the elements on the left side of idx till the start index of inorder are the left nodes of the root
        int l=idx-si;

        //sp+1 because we find the next root on the left side of the orig root
        //sp+1 to sp+l are all the left nodes of the root sp node in preorder
        //si to idx-1 also have all the left nodes of the root node in inorder (or the left side of the idx pos)
        root.left = build(pre, sp+1, sp+l, in, si, idx-1);

        //Since sp+l are root+its left nodes we make the new right node after those i.e. sp+l+1
        //idx+1 to ei has the rigth node in the inorder (or the right side at idx pos)
        root.right= build(pre, sp+l+1, ep, in, idx+1, ei);

        return root;
    }
}
