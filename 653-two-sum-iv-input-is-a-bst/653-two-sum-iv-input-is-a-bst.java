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
    Set<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return helper(root, k);
    }
    
    private boolean helper(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        boolean left = helper(root.left, k);
        if(left){
            return true;
        }
        if(set.contains(k-root.val)){
            return true;
        }else{
            set.add(root.val);
        }
        boolean right = helper(root.right, k);
        if(right){
            return true;
        }
        return false;
    }
}