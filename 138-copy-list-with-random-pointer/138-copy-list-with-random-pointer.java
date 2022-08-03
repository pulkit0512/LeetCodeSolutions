/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node temp = head;
        while(temp!=null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        
        temp = head;
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        
        Node cloneHead = head.next;
        Node cloneTemp = cloneHead;
        temp = head;
        
        while(temp!=null){
            temp.next = temp.next.next;
            if(cloneTemp.next!=null){
                cloneTemp.next = cloneTemp.next.next;
            }else{
                cloneTemp.next = null;
            }
            temp = temp.next;
            cloneTemp = cloneTemp.next;
        }
        
        return cloneHead;
    }
}