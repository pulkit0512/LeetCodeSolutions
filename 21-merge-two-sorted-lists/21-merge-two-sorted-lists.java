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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode newHead = null, newTail = null;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                if(newHead==null){
                    newHead = list1;
                    newTail = list1;
                }else{
                    newTail.next = list1;
                    newTail = list1;
                }
                list1 = list1.next;
            }else{
                if(newHead==null){
                    newHead = list2;
                    newTail = list2;
                }else{
                    newTail.next = list2;
                    newTail = list2;
                }
                list2 = list2.next;
            }
        }
        if(list1==null){
            newTail.next = list2;
        }
        if(list2==null){
            newTail.next = list1;
        }
        return newHead;
    }
}