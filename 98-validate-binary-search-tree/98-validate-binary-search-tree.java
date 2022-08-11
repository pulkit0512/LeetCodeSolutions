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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBSTUtil(TreeNode root, long min, long max) {
        if(root==null){
            return true;
        }
        if(root.val<min || root.val>max){
            return false;
        }
        return isValidBSTUtil(root.left, min, root.val-1L) && isValidBSTUtil(root.right, root.val+1L, max);
    }
}