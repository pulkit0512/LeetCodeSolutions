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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode temp1 = l1, temp2 = l2;
        ListNode prev = l1;
        int carry = 0;
        while(temp1!=null && temp2!=null){
            int val = temp1.val + temp2.val + carry;
            temp1.val = val%10;
            carry = val/10;
            prev = temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if(temp2!=null){
            prev.next = temp2;
            while(temp2!=null){
                temp2.val = temp2.val + carry;
                carry = temp2.val/10;
                temp2.val = temp2.val%10;
                prev = temp2;
                temp2 = temp2.next;
            }
        }
        while(temp1!=null){
            temp1.val = temp1.val + carry;
            carry = temp1.val/10;
            temp1.val = temp1.val%10;
            prev = temp1;
            temp1 = temp1.next;
        }
        if(carry==1){
            prev.next = new ListNode(1);
        }
        return l1;
    }
}