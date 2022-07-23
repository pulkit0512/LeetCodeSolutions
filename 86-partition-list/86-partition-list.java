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
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = null, head2 = null;
        ListNode tail1 = null, tail2 = null;
        while(head!=null){
            if(head.val<x){
                if(head1==null){
                    head1 = head;
                    tail1 = head;
                }else{
                    tail1.next = head;
                    tail1 = head;
                }
            }else{
                if(head2==null){
                    head2 = head;
                    tail2 = head;
                }else{
                    tail2.next = head;
                    tail2 = head;
                }
            }
            head = head.next;
        }
        if(tail1==null){
            return head2;
        }else if(tail2==null){
            return head1;
        }else{
            tail1.next = head2;
            tail2.next = null;
            return head1;
        }
    }
}