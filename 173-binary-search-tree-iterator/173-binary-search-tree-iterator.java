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

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        leftMostInorder(root);
    }
    
    private void leftMostInorder(TreeNode root) {
        TreeNode node = root;
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        TreeNode nextNode = stack.pop();
        
        if(nextNode.right!=null){
            leftMostInorder(nextNode.right);
        }
        
        return nextNode.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */