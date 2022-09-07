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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        tree2strUtil(root, sb);
        return sb.toString();
    }
    
    private void tree2strUtil(TreeNode root, StringBuilder sb) {
        if(root == null){
            return;
        }
        
        sb.append(root.val);
        
        // For left child
        if(root.left!=null){
            sb.append('(');
            tree2strUtil(root.left, sb);
            sb.append(')');
        }
        
        if(root.right!=null){
            if(root.left==null){
                sb.append("()");
            }
            sb.append('(');
            tree2strUtil(root.right, sb);
            sb.append(')');
        }
    }
}