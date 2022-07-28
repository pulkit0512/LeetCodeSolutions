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
    public void flatten(TreeNode root) {
        flattenUtil(root);
    }
    
    private TreeNode flattenUtil(TreeNode root) {
        if(root==null){
            return null;
        }
        
        if(root.left==null && root.right==null){
            return root;
        }
        
        TreeNode leftTail = flattenUtil(root.left);
        TreeNode rightTail = flattenUtil(root.right);
        
        if(leftTail!=null){
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        return rightTail==null ? leftTail : rightTail;
    }
}