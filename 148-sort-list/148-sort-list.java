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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode middle = getMiddle(head);
        ListNode firstHalf = head, secondHalf = middle.next;
        middle.next = null;
        
        ListNode left = sortList(firstHalf);
        ListNode right = sortList(secondHalf);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode firstHalf, ListNode secondHalf) {
        ListNode head = null, tail = null;
        while(firstHalf!=null && secondHalf!=null){
            if(firstHalf.val<secondHalf.val){
                if(head==null){
                    head = firstHalf;
                }else{
                    tail.next = firstHalf;
                }
                tail = firstHalf;
                firstHalf = firstHalf.next;
            }else{
                if(head==null){
                    head = secondHalf;
                }else{
                    tail.next = secondHalf;
                }
                tail = secondHalf;
                secondHalf = secondHalf.next;
            }
        }
        
        if(firstHalf!=null){
            tail.next = firstHalf;
        }else{
            tail.next = secondHalf;
        }
        
        return head;
    }
    
    private ListNode getMiddle(ListNode head) {
        ListNode slwPtr = head, fstPtr = head;
        while(fstPtr.next!=null && fstPtr.next.next!=null){
            slwPtr = slwPtr.next;
            fstPtr = fstPtr.next.next;
        }
        return slwPtr;
    } 
}