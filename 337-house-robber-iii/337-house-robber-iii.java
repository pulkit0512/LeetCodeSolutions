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
    class Pair {
        int inc, exc;
        public Pair(int inc, int exc) {
            this.inc = inc;
            this.exc = exc;
        }
    }
    public int rob(TreeNode root) {
        Pair p = maxMoney(root);
        return Math.max(p.inc, p.exc);
    }
    
    private Pair maxMoney(TreeNode root){
        if(root==null){
            return new Pair(0, 0);
        }
        Pair left = maxMoney(root.left);
        Pair right = maxMoney(root.right);
        int inc = left.exc + right.exc + root.val;
        int exc = Math.max(left.inc, left.exc) + Math.max(right.inc, right.exc);
        return new Pair(inc, exc);
    }
}