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
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = null, newTail = null, prevHead = null;
        ListNode cur = head;
        
        while(cur!=null) {
            ListNode prevTail = null;
            int k=2;
            while(k>0 && cur!=null){
                ListNode temp = cur;
                cur = cur.next;
                temp.next = prevHead;
                prevHead = temp;
                k--;
                if(prevTail == null){
                    prevTail = prevHead;
                }
            }
            
            if(newHead==null){
                newHead = prevHead;
                newTail = prevTail;
            }else{
                newTail.next = prevHead;
                newTail = prevTail;
            }
            prevTail.next = cur;
        }
        
        return newHead;
    }
}