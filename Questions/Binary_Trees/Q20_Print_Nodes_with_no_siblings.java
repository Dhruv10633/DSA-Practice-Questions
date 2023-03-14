//https://hack.codingblocks.com/app/contests/3830/918/problem
package Binary_Trees;
import java.util.*;

public class Q20_Print_Nodes_with_no_siblings {
    class Node{
        int data;
        Node left,right;
    }

    private void sibling(Node root) {
			
        LinkedList<Node> q=new LinkedList<>();
        
        q.addFirst(root);

        while(!q.isEmpty()){				
            Node temp=q.removeFirst();
            if(temp.left!=null) q.addLast(temp.left);
            if(temp.right!=null) q.addLast(temp.right);

            if(temp.left!=null && temp.right==null){
                System.out.print(temp.left.data+" ");
            }
            else if(temp.left==null && temp.right!=null){
                System.out.print(temp.right.data+" ");
            }
        }
    }
}
