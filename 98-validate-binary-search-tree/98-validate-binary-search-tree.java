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
        if(root==null){
            return true;
        }
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBSTUtil(TreeNode root, long min, long max){
        if(root==null){
            return true;
        }
        if(root.val<min || root.val>max){
            return false;
        }
        boolean left = isValidBSTUtil(root.left, min, (long)root.val-1);
        if(!left){
            return false;
        }
        boolean right = isValidBSTUtil(root.right, (long)root.val+1, max);
        return right;
    }
}