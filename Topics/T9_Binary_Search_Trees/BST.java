package T9_Binary_Search_Trees;

import java.util.*;;

public class BST {
    //skew tree :when the tree is either totally left sided or right sided

    public class Node{
        int data=0;
        Node left=null;
        Node right=null;
    }

    private Node root;


    //Creating BST
    public void createTree(int[] arr){
        this.root=createTree(arr, 0, arr.length-1)
    }

    public Node createTree(int[] arr,int s,int e){

        if(s>e) return null;

        int mid=(s+e)/2;
        Node n=new Node();
        n.data=arr[mid];

        n.left=createTree(arr, s, mid-1);
        n.right=createTree(arr, mid+1, e);

        return n;
    }

    //Insert a node

    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     if(root==null){
    //         TreeNode temp=new TreeNode(val);
    //         return temp;
    //     }

    //     if(val>root.val){
    //         root.right=insertIntoBST(root.right,val);
    //     }
    //     else{
    //         root.left=insertIntoBST(root.left,val);
    //     }
    //     return root;
    // }

    //Balance Factor (BF)=left child height-right child height
    //Tree is said to be balanced if BF==0 || BF==-1 || BF==1


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        BST t =new BST();
        t.createTree(arr);


    }
}
