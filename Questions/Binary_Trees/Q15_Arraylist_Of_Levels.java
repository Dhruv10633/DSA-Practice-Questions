//https://hack.codingblocks.com/app/contests/3830/151/problem
package Binary_Trees;

import java.util.*;
class Main{

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		BinaryTree bt1 = m.new BinaryTree();
		System.out.println(bt1.levelArrayList());
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public ArrayList<ArrayList<Integer>> levelArrayList() {

			// write your code here

			int s=1;
			LinkedList<Node> q=new LinkedList<>();
			ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
			ArrayList<Integer> li=new ArrayList<>();

			q.addFirst(root);

			while(!q.isEmpty()){
				s--;

				Node temp = q.removeFirst();
				li.add(temp.data);

				if(temp.left!=null) q.addLast(temp.left);
				if(temp.right!=null) q.addLast(temp.right);

				if(s==0){
					s=q.size();
					ans.add(li);
					li=new ArrayList<>();
				}
			}
			return ans;

		}

	}

}

