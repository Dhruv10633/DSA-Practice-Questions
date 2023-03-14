//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
package Binary_Trees;


class Solution {

    public TreeNode buildTree(int[] in, int[] post) {
        return construct(post, 0, post.length - 1, in, 0, in.length - 1);
    }
    
    private TreeNode construct(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {

        if(plo>phi || ilo>ihi){
            return null;
        }
        TreeNode root=new TreeNode(post[phi]);

        int index;
        for(index=ilo ; index<ihi ; index++ ){
            if(in[index]==post[phi]){
                break;
            }
        }
        int l=index-ilo;

        root.left=construct(post ,plo ,plo+l-1 ,in ,ilo ,index-1);
        root.right=construct(post ,plo+l ,phi-1 ,in ,index+1 ,ihi);
        return root;
    }
}
