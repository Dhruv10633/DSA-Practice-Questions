//https://hack.codingblocks.com/app/contests/3830/125/problem
package BST;

import java.util.*;
class Main {
    private static class Node{
        int data;
        Node left=null;
        Node right=null;
        Node(int d){
            data=d;
        }

    }

    private static Node build(int[] arr,int s,int e){
        if(s>e){
            return null;
        }
        int m=(s+e)/2;
        Node root=new Node(arr[m]);
        root.left=build(arr,s,m-1);
        root.right=build(arr,m+1,e);

        return root;
    }

    private static int sum=0;
    private static void replaceWithGRS(Node root){
        if(root==null){
            return;
        }
        replaceWithGRS(root.right);
        sum+=root.data;
        root.data=sum;
        replaceWithGRS(root.left);
    }

    private static void preOrder(Node root){
        if(root==null) return;

        System.out.print(root.data +" ");

        preOrder(root.left);
        preOrder(root.right);
    }


    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        Node root=build(arr,0,arr.length-1);
        replaceWithGRS(root);
        preOrder(root);

        sc.close();
    }
}
