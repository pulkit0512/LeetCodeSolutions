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
class Solution {
    class height {
        int ht;
        public height() {
            ht = 0;
        }
    }
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        
        //return diameterOfBinaryTreeUsingHeight(root, new height());
        
        diameter = 0;
        diameterOfBinaryTreeUtil(root);
        return diameter;
    }
    
    private int diameterOfBinaryTreeUtil(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int left = diameterOfBinaryTreeUtil(root.left);
        int right = diameterOfBinaryTreeUtil(root.right);
        
        diameter = Math.max(diameter, left+right);
        
        return Math.max(left, right) + 1;
    }
    
    private int diameterOfBinaryTreeUsingHeight(TreeNode root, height h) {
        if(root==null){
            return 0;
        }
        
        height lh = new height();
        height rh = new height();
        
        int left = diameterOfBinaryTreeUsingHeight(root.left, lh);
        int right = diameterOfBinaryTreeUsingHeight(root.right, rh);
        
        h.ht = Math.max(lh.ht, rh.ht) + 1;
        
        return Math.max(lh.ht + rh.ht, Math.max(left, right));
    }
}