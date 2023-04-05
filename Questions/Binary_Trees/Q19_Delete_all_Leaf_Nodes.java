//https://hack.codingblocks.com/app/contests/3830/451/problem

//this different
//https://leetcode.com/problems/delete-leaves-with-a-given-value/
package Binary_Trees;

class Solution{
    class Node{
        int data;
        Node left,right;
    }
    private void removeLeaves(Node root) {
			 
        // write your code here
        if(root==null) return;

        if(root.left!=null && root.left.left==null && root.left.right==null){
            root.left=null;
        }
        if(root.right!=null && root.right.left==null && root.right.right==null){
            root.right=null;
        }

        removeLeaves(root.left);
        removeLeaves(root.right);
    }

    private Node removeLeaves2(Node root) {
			 
        // write your code here
        if(root==null) return root;

        if(root.left==null && root.right==null){
            return null;
        }

        root.left = removeLeaves2(root.left);
        root.right = removeLeaves2(root.right);

        return root;
    }
}
