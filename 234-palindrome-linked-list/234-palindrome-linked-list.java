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
        if(head.next==null){
            return true;
        }
        
        ListNode firstHalf = head;
        
        int len = getLength(head);
        ListNode secondHalf = getMiddle(head, len);
        firstHalf = reverse(firstHalf);
        
        while(firstHalf!=null && secondHalf!=null){
            if(firstHalf.val!=secondHalf.val){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
    
    private int getLength(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    
    private ListNode getMiddle(ListNode head, int len) {
        ListNode secondHalf = head, prev = null;
        for(int i=0;i<len/2;i++){
            prev = secondHalf;
            secondHalf = secondHalf.next;
        }
        prev.next = null;
        return (len%2==0)?secondHalf:secondHalf.next;
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