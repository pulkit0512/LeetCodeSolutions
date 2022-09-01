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
    int nodes;
    public int goodNodes(TreeNode root) {
        nodes = 0;
        goodNodesUtil(root, Integer.MIN_VALUE);
        return nodes;
    }
    
    private void goodNodesUtil(TreeNode root, int max) {
        if(root==null){
            return;
        }
        if(root.val>=max){
            nodes++;
        }
        max = Math.max(max, root.val);
        
        goodNodesUtil(root.left, max);
        goodNodesUtil(root.right, max);
    }
}