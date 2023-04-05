//https://hack.codingblocks.com/app/contests/3830/2330/problem
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

    private static ArrayList<ArrayList<Integer>> root2Leaf(Node root,ArrayList<Integer> path){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        // System.out.print(root.data +"  ");
        path.add(root.data);
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return ans;
        }

        ArrayList<ArrayList<Integer>> left = root2Leaf(root.left, path);
        ArrayList<ArrayList<Integer>> right = root2Leaf(root.right, path);

        path.remove(path.size()-1);

        for(ArrayList<Integer> temp : left){
            ans.add(temp);
        }

        for(ArrayList<Integer> temp : right){
            ans.add(temp);
        }

        return ans;
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

        ArrayList<ArrayList<Integer>> ans = root2Leaf(root, new ArrayList<Integer>());
        
        for(ArrayList<Integer> temp: ans){
            // if(temp.isEmpty()) continue;
            for(int i=temp.size()-1 ; i>=0 ; i--){
                System.out.print(temp.get(i)+" ");
            }
            System.out.println();
        }

        sc.close();
    }
}

//Also do through ITERATION


// import java.util.*;
// public class Q23_Print_all_root_to_leaf_path {
//     private static class Node{
//         int data;
//         Node left,right;
//         Node(int d){
//             data=d;
//             left=right=null;
//         }
//     }

//     private static void helper(ArrayList<Node> level){   
        
//         for(int j=level.size()-1 ; j>=0 ; ){
//             System.out.print(level.get(j).data + " ");
//             if(j==0) break;
//             j = (j-1)/2;
//         }
//         System.out.println();
            
//     }

//     private static void root2Leaf(Node root, LinkedList<Node> q){  
//         HashSet<Node> visited=new HashSet<>();
//         ArrayList<Node> level = new ArrayList<>();

//         q.add(root);

//         while(!q.isEmpty()){
//             Node temp=q.removeFirst();

//             level.add(temp);
//             if(temp==null) continue;
            
//             q.addLast(temp.left);
//             if(temp.left!=null && !visited.contains(temp.left) && temp.left.left==null && temp.left.right==null){
//                 visited.add(temp.left);
//                 System.out.print(temp.left.data + " ");
//                 helper(level);
//             }
                            
//             q.addLast(temp.right);
//             if(temp.right!=null && !visited.contains(temp.right) && temp.right.left==null && temp.right.right==null){
//                 visited.add(temp.right);
//                 System.out.print(temp.right.data + " ");
//                 helper(level);
//             }
            
//             if(!visited.contains(temp) && temp.left==null && temp.right==null){
//                 visited.add(temp);
//                 helper(level);
//             }
//         }     
//     }



//     public static void main (String args[]) {
//         Scanner sc=new Scanner(System.in);

//         Node root=new Node(sc.nextInt());
//         LinkedList<Node> q=new LinkedList<>();

//         q.add(root);

//         while(!q.isEmpty()){
//             Node temp=q.removeFirst();

//             if(temp==null) continue;

//             int x=sc.nextInt();
//             if(x!=-1) {
//                 temp.left=new Node(x);
//                 q.addLast(temp.left);
//             }
//             else{
//                 q.addLast(null);
//             }

//             x=sc.nextInt();
//             if(x!=-1){
//                 temp.right=new Node(x);
//                 q.addLast(temp.right);
//             }
//             else{
//                 q.addLast(null);
//             }
//         }  
        
//         root2Leaf(root, q);
//     }
// }