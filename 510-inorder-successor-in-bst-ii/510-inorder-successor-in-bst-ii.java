/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node.parent==null){
            return node.right==null ? null : getRightLeftMost(node);
        }
        
        if(node.parent.left==node){
            return node.right==null ? node.parent : getRightLeftMost(node);
        }
        
        if(node.parent.right==node){
            if(node.right!=null){
                return getRightLeftMost(node);
            }else{
                while(node.parent!=null && node.parent.left!=node){
                    node = node.parent;
                }
                return node.parent;
            }
        }
        return null;
    }
    
    private Node getRightLeftMost(Node node) {
        Node rightLeftMost = node.right;
        while(rightLeftMost.left!=null){
            rightLeftMost = rightLeftMost.left;
        }
        return rightLeftMost;
    }
}