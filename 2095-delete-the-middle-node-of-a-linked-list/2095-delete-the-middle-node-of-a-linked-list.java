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
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null){
            return null;
        }
        
        ListNode prev = null;
        ListNode slwPtr = head, fstPtr = head;
        
        while(fstPtr!=null && fstPtr.next!=null){
            prev = slwPtr;
            slwPtr = slwPtr.next;
            fstPtr = fstPtr.next.next;
        }
        
        prev.next = prev.next.next;
        
        return head;
    }
}