/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node head, tail;
    public Node treeToDoublyList(Node root) {
        getCircularDLL(root);
        return head;
    }
    
    private void getCircularDLL(Node root) {
        if(root==null){
            return;
        }
        getCircularDLL(root.left);
        Node temp = root.right;
        if(head==null){
            head = root;
            tail = root;
        }else{
            tail.right = root;
            root.left = tail;
            tail = root;
        }
        head.left = tail;
        tail.right = head;
        getCircularDLL(temp);
    }
}