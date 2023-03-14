// https://hack.codingblocks.com/app/contests/3830/2144/problem
//https://leetcode.com/discuss/general-discussion/1779760/bottom-view-in-binary-tree-c-easy-code

package Binary_Trees;
import java.util.*;

class Main {
    static class Node{
        int data;
        Node left,right;
        Node(){}
        Node(int data){
            this.data=data;
            left=right=null; 
        }
    }
    
    //Not inorder
    private static class pair{
        Node node;
        int col;
        pair(Node root,int col){
            this.node=root;
            this.col=col;
        }
    }
    private static void bottomView(Node root){
        if(root==null) return;

        LinkedList<pair> q=new LinkedList<>();
        TreeMap<Integer,Integer> tmap=new TreeMap<>();

        int col=0;
        q.addFirst(new pair(root,col));
        

        while(!q.isEmpty()){
            pair temp=q.removeFirst();
            
            //It adds or replaces the already presesnt node val at the col pos
            tmap.put(temp.col,temp.node.data);

            //For TopView:
            // if(!tmap.containsKey(temp.col)){
            //     tmap.put(temp.col,temp.node.data);
            // }

            if(temp.node.left!=null) q.addLast(new pair(temp.node.left,temp.col-1));
            if(temp.node.right!=null) q.addLast(new pair(temp.node.right,temp.col+1));

        }

        for(int x : tmap.keySet()){
            System.out.print(tmap.get(x)+" ");
        }
    }

    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);

        LinkedList<Node> q=new LinkedList<>();

        Node root=new Node(sc.nextInt());
        q.addFirst(root);

        while(!q.isEmpty()){

            Node temp=q.removeFirst();

            int x=sc.nextInt();
            if(x!=-1){
                Node temp2=new Node(x);
                q.addLast(temp2);
                temp.left=temp2;
            }

            x=sc.nextInt();
            if(x!=-1){
                Node temp2=new Node(x);
                q.addLast(temp2);
                temp.right=temp2;
            }
        }
        bottomView(root);
        sc.close();
    }
}