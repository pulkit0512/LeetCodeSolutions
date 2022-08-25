/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    Stack<TreeNode> nextStack;
    Stack<TreeNode> prevStack;
    public BSTIterator(TreeNode root) {
        nextStack = new Stack<>();
        prevStack = new Stack<>();
        
        leftMostInorder(root);
    }
    
    private void leftMostInorder(TreeNode root) {
        TreeNode node = root;
        while(node!=null){
            nextStack.push(node);
            node = node.left;
        }
    }
    
    public boolean hasNext() {
        return !nextStack.isEmpty();
    }
    
    public int next() {
        TreeNode nextNode = nextStack.pop();
        
        if(nextNode.right!=null){
            leftMostInorder(nextNode.right);
            nextNode.right = null;
        }
        
        prevStack.push(nextNode);
        
        return nextNode.val;
    }
    
    public boolean hasPrev() {
        return prevStack.size()>1;
    }
    
    public int prev() {
        nextStack.push(prevStack.pop());
        
        return prevStack.peek().val;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */