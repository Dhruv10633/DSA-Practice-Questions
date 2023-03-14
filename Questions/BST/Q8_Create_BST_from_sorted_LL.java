// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
package BST;
import java.util.*;



//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



// Simple
class Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> li = new ArrayList<>();

        while(head!=null){
            li.add(head.val);
            head=head.next;
        }

        return BST(li, 0, li.size()-1);
    }

    private TreeNode BST(ArrayList<Integer> li, int l, int h){
        if(l>h){
            return null;
        }

        int m = l+(h-l)/2;

        TreeNode head = new TreeNode(li.get(m));

        head.left = BST(li, l, m-1);
        head.right = BST(li, m+1, h);

        return head;
    }
}

// Optimal
class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        
        if(head.next == null) return new TreeNode(head.val);
        
        ListNode m = middle(head);
        ListNode tHead = m.next;
        m.next=null;

        TreeNode root = new TreeNode(m.val);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(tHead);

        return root;
    }

    private ListNode middle(ListNode head){
        ListNode slow = head, prev = slow;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev!=null)prev.next = null;
        return slow;
    }
}
