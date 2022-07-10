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
    class height{
        int ht;
        public height(){
            ht=0;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        return diameterHelper(root, new height());
    }
    
    private int diameterHelper(TreeNode root, height h){
        if(root==null){
            return 0;
        }
        height lh = new height();
        height rh = new height();
        int left = diameterHelper(root.left, lh);
        int right = diameterHelper(root.right, rh);
        h.ht = Math.max(lh.ht, rh.ht) + 1;
        return Math.max(lh.ht+rh.ht, Math.max(left, right));
    }
}