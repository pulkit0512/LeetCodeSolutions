/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fastPtr = head.next, slowPtr = head;
        while(slowPtr!=fastPtr){
            if(slowPtr==null || fastPtr==null || fastPtr.next==null){
                return false;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return true;
    }
}