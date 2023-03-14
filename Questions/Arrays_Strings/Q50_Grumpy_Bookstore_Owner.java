//https://leetcode.com/problems/grumpy-bookstore-owner/submissions/876682308/
package Arrays_Strings;
import java.util.*;

class Solution {
    public int maxSatisfied(int[] cust, int[] grumpy, int min) {
        int s=0, e=0;
        int max_cust=0, curr_cust=0;
        //a linked list to get the first and last index of when owner grumpy
        LinkedList<Integer> index=new LinkedList<>();

        while(e<grumpy.length){
            curr_cust+=cust[e];
            if(grumpy[e]==1){
                index.addLast(e);

                //while all 1s are within the min value for which the owner can keep himself ungrumpy
                while(index.getLast()+1 - index.getFirst() > min){
                    //only removing the happy customers if he was grumpy
                    //since the custs will be satisfied if he is not grumpy do no need to delete them
                    if(grumpy[s]==1){
                        index.removeFirst();
                        curr_cust-=cust[s];
                    }
                    s++;
                }
            }
            //this to keep adding the statisfied the custs even if not within the max window 
            //since the custs will be satisfied if he is not grumpy even after the max wind is finished
            else{
                max_cust+=cust[e];
            }

            max_cust=Math.max(max_cust, curr_cust);
                    
            e++;
        }
        return max_cust;
    }
}
