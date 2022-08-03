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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l1 = head, l2 = head;
        for(int i=0;i<n;i++){
            l1 = l1.next;
        }
        if(l1==null){
            return l2.next;
        }
        while(l1.next!=null){
            l1 = l1.next;
            l2 = l2.next;
        }
        l2.next = l2.next.next;
        return head;
    }
}