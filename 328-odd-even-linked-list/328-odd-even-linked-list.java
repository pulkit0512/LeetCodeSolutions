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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode oddHead = null, oddTail = null;
        ListNode evenHead = null, evenTail = null;
        int flag = 1;
        ListNode temp = head;
        while(temp!=null){
            if(flag==1){
                if(oddHead==null){
                    oddHead = temp;
                    oddTail = temp;
                } else{
                    oddTail.next = temp;
                    oddTail = temp;
                }
                flag = 2;
            } else{
                if(evenHead==null){
                    evenHead = temp;
                    evenTail = temp;
                } else{
                    evenTail.next = temp;
                    evenTail = temp;
                }
                flag = 1;
            }
            temp = temp.next;
        }
        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;
    }
}