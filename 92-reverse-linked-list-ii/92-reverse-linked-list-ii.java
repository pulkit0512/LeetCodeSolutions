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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode temp = head;
        int idx = 1;
        while(idx<=right){
            if(idx!=left){
                prev = temp;
                idx++;
                temp = temp.next;
            }else{
                ListNode p1 = null, n1 = null;
                ListNode tail = temp;
                while(idx<=right){
                    idx++;
                    n1 = temp.next;
                    temp.next = p1;
                    p1 = temp;
                    temp = n1;
                }
                if(prev!=null){
                    prev.next = p1;
                }else{
                    head = p1;
                }
                tail.next = temp;
            }
        }
        return head;
    }
}