//https://hack.codingblocks.com/app/contests/3830/2153/problem
package Binary_Trees;

import java.util.*;
class Main {
    private static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    private static void cousins(Node root,LinkedList<Node> q,int target){
        q.add(root);
        int s=1 ,found = -1;
        
        while(!q.isEmpty()){
            s--;
            Node temp=q.removeFirst();

            if((temp.left!=null && temp.left.data==target) || (temp.right!=null && temp.right.data==target)){
                found=1;
            }
            else{
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }

            if(s==0){
                if(found==1) break;
                s=q.size();
            }
        } 
        if(q.isEmpty()){
            System.out.print(-1);
            return;
        }
        for(Node x:q){
            System.out.print(x.data+" ");
        }
    }

    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);

        Node root=new Node(sc.nextInt());
        LinkedList<Node> q=new LinkedList<>();

        q.add(root);
       
        while(!q.isEmpty()){
            
            Node temp=q.removeFirst();

            int x=sc.nextInt();
            
            if(x!=-1) {
                temp.left=new Node(x);
                q.addLast(temp.left);
            }

            x=sc.nextInt();
            if(x!=-1){
                temp.right=new Node(x);
                q.addLast(temp.right);
            }
        } 

        int target = sc.nextInt();

        cousins(root,q,target);

        sc.close();
    }
}
