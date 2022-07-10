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
    public boolean isBalanced(TreeNode root) {
        return isBalancedUtil(root).getValue();
    }
    
    private Pair<Integer, Boolean> isBalancedUtil(TreeNode root) {
        if(root==null){
            return new Pair<>(0, true);
        }
        
        Pair<Integer, Boolean> left = isBalancedUtil(root.left);
        if(!left.getValue()){
            return new Pair<>(0, false);
        }
        Pair<Integer, Boolean> right = isBalancedUtil(root.right);
        if(!right.getValue()){
            return new Pair<>(0, false);
        }
        
        if(Math.abs(left.getKey()-right.getKey())<=1){
            return new Pair<>(Math.max(left.getKey(), right.getKey()) + 1, true);
        }else{
            return new Pair<>(0, false);
        }
    }
}