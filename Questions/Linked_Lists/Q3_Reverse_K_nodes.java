// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
package Linked_Lists;

class Solution {

    public ListNode reverse_k(ListNode head,int k){
        ListNode prev=null;
        ListNode curr=head;
        ListNode nxt=curr.next;

        while(nxt!=null && k-->1){
            curr.next=prev;
            prev=curr;
            curr=nxt;
            nxt=curr.next;
        }
        curr.next=prev;  //Basic reverse complete
        
        //linking the head node    which after reversing is tail to the next node
        //to make it continuous
        head.next=nxt;
        
        return  curr;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==0 || k==1 ){
            return head;
        }

        ListNode curr=head;
        int n=0;
        while(curr!=null){
            n++;
            curr=curr.next;
        }

        curr=head;
        ListNode temp=null,prev_curr=null;
        int check=0;

        while(curr!=null){
            if(n<k) break;
            temp=reverse_k(curr,k);

            //only for the 1st reverse as list head changes here
            if(check==0){
                head=temp;
                check=1;
            }
            else{
                prev_curr.next=temp;
            }
            
            prev_curr=curr;
            curr=curr.next;
            n-=k;
        }

        return head;
    }
}