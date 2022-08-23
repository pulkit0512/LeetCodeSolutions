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
        
        while(firstHalf!=null && secondHalf!=null){
            if(firstHalf.val!=secondHalf.val){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
    
    private ListNode getMiddle(ListNode head) {
        ListNode slowPtr = head, fastPtr = head;
        
        while(fastPtr.next!=null && fastPtr.next.next!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        
        return slowPtr;
    }
    
    private ListNode reverse(ListNode firstHalf) {
        ListNode cur = firstHalf, prev = null, next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}