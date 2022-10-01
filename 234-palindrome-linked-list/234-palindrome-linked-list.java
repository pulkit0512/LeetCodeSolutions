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
    public boolean isPalindrome(ListNode head) {
        ListNode firstHalf = head;
        ListNode middle = getMiddle(head);
        ListNode secondHalf = reverse(middle.next);
        middle.next = null;
        
        while(firstHalf!=null && secondHalf!=null){
            if(firstHalf.val!=secondHalf.val){
                return false;
            }
            
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
    
    private ListNode getMiddle(ListNode node) {
        ListNode slwPtr = node, fstPtr = node;
        
        while(fstPtr.next!=null && fstPtr.next.next!=null){
            slwPtr = slwPtr.next;
            fstPtr = fstPtr.next.next;
        }
        
        return slwPtr;
    }
    
    private ListNode reverse(ListNode node) {
        ListNode cur = node, prev = null, next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}