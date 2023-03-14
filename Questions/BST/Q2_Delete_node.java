package BST;

public class Q2_Delete_node {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        //Right traversal
        if(key > root.val){
            root.right=deleteNode(root.right,key);
        }
        //Left Traversal
        else if(key < root.val){
            root.left=deleteNode(root.left,key);
        }
        //if we found the key
        else{
            if(root.left==null){
                return root.right;
            }
            else if (root.right==null){
                return root.left;
            }

            //if no subtree we just delete the node and return null
            else if (root.left==null && root.right==null){
                return null;
            }

            //if both left and right subtree present
            else{

                //Method1 finding max from left sub tree
                    // int l_max= max(root.left);

                    // //now we delete the "l_max" node since we have to put it at root node
                    // root.left=deleteNode(root.left,l_max);

                    // //assigning l_max val or node to node to be deleted(which is the root node RN.)
                    // root.val=l_max;

                //Method2 finding min from left sub-tree
                
                    int r_min=min(root.right);
                    root.right=deleteNode(root.right,r_min);
                    root.val=r_min;
                
                return root;
            }
        }

        return root;
    }

    //l_max
    // private int max(TreeNode root){
    //     if(root.right==null){
    //         return root.val;
    //     }

    //     return max(root.right);
    // }

    //r_min
    private int min(TreeNode root){
        if(root.left==null){
            return root.val;
        }

        return min(root.left);
    }
}
