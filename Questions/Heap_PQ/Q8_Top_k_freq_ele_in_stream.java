//https://hack.codingblocks.com/app/contests/3830/409/problem
package Heap_PQ;

import java.util.*;
class Main {
    private static class pair{
        int ele;
        int freq;
        pair(int e,int f){
            ele=e;
            freq=f;
        }
    }

    private static void display(PriorityQueue<pair> pq,int k){
        while(!pq.isEmpty() && k-->0){
            System.out.print(pq.remove().ele + " ");
        }

        if(!pq.isEmpty()) pq=new PriorityQueue<pair>((p1,p2)->(p1.freq!=p2.freq ? p2.freq-p1.freq : p1.ele-p2.ele)); 
    }

    private static void topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        PriorityQueue<pair> pq=new PriorityQueue<pair>((p1,p2)->(p1.freq!=p2.freq ? p2.freq-p1.freq : p1.ele-p2.ele));

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);

            for(int x:mp.keySet()){
                pq.add(new pair(x, mp.get(x)));
            }
            display(pq,k);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();

            int []nums=new int[n];

            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }

            topKFrequent(nums,k);
        }
        sc.close();
    }
}
