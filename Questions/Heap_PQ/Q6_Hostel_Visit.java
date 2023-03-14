//https://hack.codingblocks.com/app/contests/3830/401/problem
package Heap_PQ;

import java.util.*;
class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        long q=sc.nextLong(),k=sc.nextLong();
        
        //For Long use reverse.... (a,b)->(b-a) doesn't work here
        PriorityQueue<Long> maxH=new PriorityQueue<>(Collections.reverseOrder());

        while(q-->0){
            long temp=sc.nextLong();
            
            if(temp==1){
                long a=sc.nextLong(),b=sc.nextLong();
                long rockDist=a*a+b*b;

                if(maxH.size()<k) maxH.add(rockDist);

                else{
                    if(rockDist < maxH.peek()){
                        maxH.remove();
                        maxH.add(rockDist);
                    }
                }
            }
            else{
                System.out.println(maxH.peek());
            }
        }
        sc.close();
    }
}
