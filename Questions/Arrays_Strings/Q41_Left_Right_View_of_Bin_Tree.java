package Arrays_Strings;

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

    private static void leftView(Node root){
        if(root==null) return;

        LinkedList<Node> q=new LinkedList<>();
		TreeMap<Integer,Integer> tmap=new TreeMap<>();

        int s=1,l=1;
        q.addFirst(root);

        while(!q.isEmpty()){
			s--;
            Node temp=q.removeFirst();
			
			if(!tmap.containsKey(l)){
				tmap.put(l,temp.data);
			}

            if(temp.left!=null) q.addLast(temp.left);
            if(temp.right!=null) q.addLast(temp.right);

			if(s==0){
				s=q.size();
				l++;
			}

        }

        for(int x : tmap.keySet()){
            System.out.print(tmap.get(x)+" ");
        }
    }

	private static void rightView(Node root){
		if(root==null) return;

        LinkedList<Node> q=new LinkedList<>();
		TreeMap<Integer,Integer> tmap=new TreeMap<>();

        int s=1,l=1;
        q.addFirst(root);

        while(!q.isEmpty()){
			s--;
            Node temp=q.removeFirst();
			
			tmap.put(l,temp.data);

            if(temp.left!=null) q.addLast(temp.left);
            if(temp.right!=null) q.addLast(temp.right);

			if(s==0){
				s=q.size();
				l++;
			}

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
        rightView(root);

    }
}
