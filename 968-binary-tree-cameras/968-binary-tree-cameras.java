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
    Set<TreeNode> covered;
    int cameras;
    public int minCameraCover(TreeNode root) {
        covered = new HashSet<>();
        cameras = 0;
        covered.add(null);
        helper(root, null);
        return cameras;
    }
    
    private void helper(TreeNode root, TreeNode par) {
        if(root==null){
            return;
        }
        helper(root.left, root);
        helper(root.right, root);
        if((par==null && !covered.contains(root)) || !covered.contains(root.left) || !covered.contains(root.right)){
            cameras++;
            covered.add(root);
            covered.add(par);
            covered.add(root.left);
            covered.add(root.right);
        }
    }
}