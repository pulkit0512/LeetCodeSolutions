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
    int path;
    public int longestConsecutive(TreeNode root) {
        path = 0;
        longestConsecutiveUtil(root);
        return path;
    }
    
    private int longestConsecutiveUtil(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int left = longestConsecutiveUtil(root.left);
        int right = longestConsecutiveUtil(root.right);
        
        int rootPath = 1;
        if(root.left!=null && root.left.val == root.val + 1){
            rootPath = 1 + left;
        }
        
        if(root.right!=null && root.right.val == root.val + 1){
            rootPath = Math.max(rootPath, 1 + right);
        }
        
        int curMax = Math.max(rootPath, Math.max(left, right));
        
        path = Math.max(path, curMax);
        
        return rootPath;
    }
}