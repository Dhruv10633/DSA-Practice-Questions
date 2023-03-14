// package T8_Binary_Trees;
import java.util.*;

class Node{
    int data=0;
    Node left=null;
    Node right=null;
}

public class Binary_Trees {
    
    
    static Scanner sc=new Scanner(System.in);

    public static Node createTree(int x){
        Node temp=new Node();
        temp.data=x;
        
        //to check if left child there
        if(sc.nextBoolean()){
            temp.left=createTree(sc.nextInt());
        }
        if(sc.nextBoolean()){
            temp.right=createTree(sc.nextInt());
        }
        return temp;
    }

    public static void display(Node root){
        if(root==null){
            return;
        }
        String s="<--"+root.data+"-->";

        if(root.left!=null){
            s= root.left.data + s;
        }

        if(root.right!=null){
            s= s + root.right.data;
        }

        System.out.println(s);

        display(root.left);
        display(root.right);
    }

    public static boolean find(Node root,int x) {
        if(root==null){
            return false;
        }

        if(root.data==x){
            return true;
        }

        // we do this in stead of writing find (root.left,x) nad the other in diff erent lines
        // so that if we find the x in the left part it doesn'y execute the right part;
        return find(root.left,x) || find(root.right ,x);
    }


    static int temp_max=-1;
    public static int max_node(Node root) {
        if(root==null){
            return temp_max;
        } 
        temp_max=Math.max(temp_max,root.data);

        max_node(root.left);
        max_node(root.right);

        return temp_max;
    }

    public static int height(Node root,int ht) {
        if(root==null){
            return -1;
        }
        
        int l=height(root.left, ht)+1;
        int r=height(root.right, ht)+1;
        return Math.max(l,r);
    }

    /////////////////////////////////////////////Depth-First Search//////////////////////////////

    //Pre-order Traversal : Print root,left subtree , then right subtree
    public static void preOrder_traversal(Node root) {
        if(root==null) return;

        System.out.println(root.data);
        preOrder_traversal(root.left);
        preOrder_traversal(root.right);

    }

    //Post-order Traversal: print left,right then root
    public static void postOrder_traversal(Node root) {
        if(root==null) return;

        postOrder_traversal(root.left);
        postOrder_traversal(root.right);
        System.out.println(root.data);

    }

    //In-order Traversal: print left,root,right 
    public static void inOrder_traversal(Node root) {
        if(root==null) return;

        inOrder_traversal(root.left);
        System.out.println(root.data);
        inOrder_traversal(root.right);
    }


    ////////////////////////////////////////////Breadth-first-Search////////////////////////////////

    //Level order Traversal :print all nodes on the same level from left to right
    public static void levelOrder_traversal(Node root) {
        if(root==null) return;

        Node h=root;
    
        LinkedList<Node> queue =new LinkedList<>();

        queue.add(h);
        while(!queue.isEmpty()){
            //by default ll.add() adds at end of linked
            //and ll.remove() deleted from 0
            Node temp=queue.remove();
            if(temp.left!=null)queue.add(temp.left);
            if(temp.right!=null)queue.add(temp.right);
            System.out.println(temp.data);
        }

    }

    public static void main(String[] args) {
        //Trees are hierarchal data structures

        //Generic Trees
        //Tree without any limitations on number of child nodes etc

        //Binary Tree
        //each parent can have at max 2 children

        Node root1=null;  //bin tree root

        root1=createTree(sc.nextInt());

        display(root1);

        System.out.println(find(root1,2));
        System.out.println(max_node(root1));
        System.out.println(height(root1,-1));

        //DFS
        System.out.println();
        preOrder_traversal(root1);
        System.out.println();
        postOrder_traversal(root1);
        System.out.println();
        inOrder_traversal(root1);

        System.out.println();

        //BFS
        levelOrder_traversal(root1);
        sc.close();
    }
    
}
