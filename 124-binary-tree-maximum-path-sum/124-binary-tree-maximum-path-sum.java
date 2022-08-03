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
    int ans;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        ans = Integer.MIN_VALUE;
        maxPathSumUtil(root);
        return ans;
    }
    
    private int maxPathSumUtil(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int leftSum = maxPathSumUtil(root.left);
        int rightSum = maxPathSumUtil(root.right);
        
        int rootVal = Math.max(Math.max(leftSum, rightSum) + root.val, root.val);
        int rootSum = Math.max(leftSum + rightSum + root.val, rootVal);
        ans = Math.max(ans, rootSum);
        
        return rootVal;
    }
}