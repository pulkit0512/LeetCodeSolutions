/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0, m = 0;
        ListNode tempA = headA, tempB = headB;
        while(tempA!=null || tempB!=null){
            if(tempA!=null) {
                n++;
                tempA = tempA.next;
            }
            if(tempB!=null){
                m++;
                tempB = tempB.next;
            }
        }
        tempA = headA;
        tempB = headB;
        while(n>m){
            tempA = tempA.next;
            n--;
        }
        while(m>n){
            tempB = tempB.next;
            m--;
        }
        while(tempA!=null){
            if(tempA==tempB){
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}