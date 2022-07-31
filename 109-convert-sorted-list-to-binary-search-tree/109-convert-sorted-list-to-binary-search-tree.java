/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        //return sortedListToBstByFindingMiddle(head);
        return sortedListToBstUsingInorderProperty(head);
    }
    
    ListNode head;
    private TreeNode sortedListToBstUsingInorderProperty(ListNode head) {
        if(head == null){
            return null;
        }
        this.head = head;
        int size = getSize(head);
        
        return sortedListUtil(0, size-1);
    }
    
    private TreeNode sortedListUtil(int st, int ed) {
        if(ed<st){
            return null;
        }
        int mid = (st+ed)/2;
        
        TreeNode left = sortedListUtil(st, mid-1);
        TreeNode node = new TreeNode(head.val);
        node.left = left;
        head = head.next;
        node.right = sortedListUtil(mid+1, ed);
        
        return node;
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        ListNode ptr = head;
        while(ptr!=null){
            ptr = ptr.next;
            size++;
        }
        return size;
    }
    
    private TreeNode sortedListToBstByFindingMiddle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode mid = getMiddleNode(head);
        
        TreeNode root = new TreeNode(mid.val);
        
        if(mid==head){
            return root;
        }
        
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        
        return root;
    }
    
    private ListNode getMiddleNode(ListNode head) {
        ListNode slwPtr = head;
        ListNode fastPtr = head;
        ListNode prevPtr = null;
        while(fastPtr!=null && fastPtr.next!=null){
            prevPtr = slwPtr;
            slwPtr = slwPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        if(prevPtr!=null) {
            prevPtr.next = null;
        }
        
        return slwPtr;
    }
}