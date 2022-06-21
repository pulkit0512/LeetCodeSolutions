/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //return connectBFS(root);
        return connectDFS(root);
    }
    private Node connectDFS(Node root) {
        if(root==null){
            return null;
        }
        if(root.left!=null){
            root.left.next = root.right;
        }
        if(root.right!=null){
            if(root.next==null){
                root.right.next=null;
            }else{
                root.right.next=root.next.left;
            }
        }
        connectDFS(root.left);
        connectDFS(root.right);
        return root;
    }
    
    private Node connectBFS(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        while(que.size()>1){
            Node temp = que.poll();
            if(temp==null){
                que.add(null);
                continue;
            }
            temp.next = que.peek();
            if(temp.left!=null){
                que.add(temp.left);
            }
            if(temp.right!=null){
                que.add(temp.right);
            }
        }
        return root;
    }
}