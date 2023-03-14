//https://hack.codingblocks.com/app/contests/3830/78
package Binary_Trees;
import java.util.*;


class Main {
    private static class Node{
        Node left,right;
        int data;
        int col;
        Node(int data,int col){
            this.data=data;
            this.col=col;
            left=right=null;
        }
    }
     

    private static void levelOrderWithPreOrder(Node root){
        TreeMap<Integer,ArrayList<Integer>> vert=new TreeMap<>();

        levelOrderWithPreOrder(root,vert);

        for(int x : vert.keySet()){
            ArrayList<Integer> temp= vert.get(x);
            for(int i=0;i<temp.size();i++){
                System.out.print(temp.get(i)+" ");
            }
        }
    }

    private static void levelOrderWithPreOrder(Node root, TreeMap<Integer,ArrayList<Integer>> vert){
        if(root==null){
            return;
        }

        if(vert.containsKey(root.col)){
            vert.get(root.col).add(root.data);
        }
        else{
            ArrayList<Integer> li=new ArrayList<>();
            li.add(root.data);
            vert.put(root.col, li);
        }

        levelOrderWithPreOrder(root.left , vert);
        levelOrderWithPreOrder(root.right, vert);

    }



    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);

        LinkedList<Node> q=new LinkedList<>();

        // int levels=sc.nextInt();

        Node root=new Node(sc.nextInt(),0);
        q.addFirst(root);

        while(!q.isEmpty()){
            Node temp=q.removeFirst();

            int x=sc.nextInt();
            if(x!=-1){
                Node left=new Node(x,temp.col-1);
                temp.left=left;
                q.addLast(left);
            }

            x=sc.nextInt();
            if(x!=-1){
                Node right=new Node(x,temp.col+1);
                temp.right=right;
                q.addLast(right);
            }
        }  
        levelOrderWithPreOrder(root);  
        sc.close(); 
    }
}
