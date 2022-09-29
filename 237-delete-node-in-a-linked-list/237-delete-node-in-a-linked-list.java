/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Since this is not a tail node
        // Instead of deleting provided node, we can copy next node data to provided node
        // and delete next node.
        node.val = node.next.val;
        node.next = node.next.next;
    }
}