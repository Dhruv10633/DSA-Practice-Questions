// package Topics.T11_Heaps_Priority_Queues;

import java.util.ArrayList;

public class Heap {
    
    //CBT (Complete Binary Tree)(not BST) : 

    //All nodes till (n-1) should be completely filled
    //the last nth level can be empty or any num of nodes
    //(but in Level order traversal the last level nodes should not have any null while writing or no space between those nodes 
    //eg 2,4,6,null,8 (shouldn't be like this) )

    //Priority Queue (PQ):

    //Elements would be removed acc to their priority
    //It follows the CBT too

    //Heap:

    //It is a combination of both PQ nad CBT (follows both properties).
    
    //Heaps are of 2 types:
    //Heap properties:
    //  1. Min Heap : Elemnts are inserted to the CBT and the min element is always at the parent node
    //  2. Max Heap : Elemnts are inserted to the CBT and the max element is always at the parent node


    // Heap from collections:
    //Min heap
    // PriorityQueue<Integer> minh= new PriorityQueue<>();

    //Max Heap
    // PriorityQueue<Integer> minh= new PriorityQueue<>(Collections.reverseOrder());
    // PriorityQueue<Integer> minh= new PriorityQueue<>((a,b)->(b-a));

    public static void main(String[] args) {
        minHeap h1=new minHeap();
        h1.add(20);
        h1.add(24);
        h1.add(30);
        h1.add(25);
        h1.add(27);
        h1.add(35);
        h1.add(39);
        h1.add(28);
        
        h1.display();

        h1.add(17);

        h1.display();

    }

}

class minHeap{
    

    //Priority queue
    private ArrayList<Integer> pq =new ArrayList<>();

    ///////////////////////////////////////////////////////////////////////////
    
    //insert in heap

    public void add(int x){
        pq.add(x);
        upHeapify(pq.size()-1);
    }

    private void upHeapify(int c){

        //P=(C-1)/2;  to find out parent if we know child index
        int p=(c-1)/2;

        //no parent above
        if(p<0) return;
        
        //if par. > child
        if(pq.get(p)> pq.get(c)){
            swap(p,c);

            // after swap we now take the par. as child and check above ,
            // if our swap lead to further problems up in the CBT
            upHeapify(p);
        }

    }

    ///////////////////////////////////////////////////////////////////////////
    
    //Delete in heap (poll,remove)

    public int remove(){
        //we need to delete the 1st index ele (to prevent hassle we swap with the last)
        swap(0, pq.size()-1);

        int x=pq.remove(pq.size()-1);

        downHeapify(0);

        return x;
    }

    private void downHeapify(int p){

        int l=2*p +1;
        int r=2+p +2;

        // no child exists
        if(l>=pq.size()) return;

        int min=p;
        //checking with left child
        if(pq.get(l)<pq.get(min)){
            min=l;
        }
        //checking with right child
        if(pq.get(r)<pq.get(min)){
            min=r;
        }

        //if the value of min changes, swap parent with the min child
        if(p!=min){
            swap(p,min);
            downHeapify(min);
        }
    }

    //////////////////////////////////////////////////////////////////////////

    private void swap(int a,int b){
        int temp=pq.get(a);

        pq.set(a,pq.get(b));
        pq.set(b,temp);
    }

    public void display() {
        System.out.println(pq);   
    }
}
