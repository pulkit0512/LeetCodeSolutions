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
    public TreeNode pruneTree(TreeNode root) {
        boolean child = pruneTreeUtil(root);
        if(!child && root.val==0){
            root = null;
        }
        
        return root;
    }
    
    private boolean pruneTreeUtil(TreeNode root) {
        if(root == null){
            return false;
        }
        
        boolean left = pruneTreeUtil(root.left);
        boolean right = pruneTreeUtil(root.right);
        
        if(!left){
            root.left = null;
        }
        if(!right){
            root.right = null;
        }
        
        if(!left && !right && root.val==0){
            return false;
        }
        return true;
    }
}