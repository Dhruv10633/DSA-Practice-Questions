//https://hack.codingblocks.com/app/contests/3830/1351/problem
package Heap_PQ;

import java.util.*;
class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            //Min heap for right side
            PriorityQueue<Integer> right=new PriorityQueue<>();
            //Max heap for left side
            PriorityQueue<Integer> left=new PriorityQueue<>(Collections.reverseOrder());
            
            //We need to decide either left/right heap to have the extra element,
            //when the number of ele are odd .(either one is fine)
            //here we take left side maxHeap
            for(int i=0;i<n;i++){

                int temp=sc.nextInt();

                //in case empty (if left empty then right definitely empty as we fill left always 1st here)
                if(left.size()==0){
                    left.add(temp);
                }
                else{
                    //if temp > left max Heap then we add it to the right side
                    if(temp>left.peek()){
                        right.add(temp);
                    }
                    //else left side
                    else{
                        left.add(temp);
                    }
                }

                //if the left side becomes greater than the right side by more than 1 ele
                //then we balance the heaps
                if(left.size() > right.size() +1){
                    right.add(left.remove());
                }
                //here if the right side ever becomes greater than left even by 1 element we balance it to become equal
                else if(right.size() > left.size()){
                    left.add(right.remove());
                }

                //if sizes same
                if(left.size()==right.size()){
                    int sum=left.peek()+right.peek();
                    System.out.print(sum/2+" ");     
                }
                //ALWAYS the left side will be greater because we have designed the algo as such
                else{
                    System.out.print(left.peek() + " ");
                }
                
            }
            System.out.println();
        } 
        
        sc.close();      
    }
}
