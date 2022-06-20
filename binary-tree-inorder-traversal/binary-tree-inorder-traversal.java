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
    
    //Morris Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while(root!=null){
            if(root.left==null){
                ans.add(root.val);
                root = root.right;
            }else{
                TreeNode leftRightMost = getLeftRightMost(root);
                if(leftRightMost.right==null){
                    leftRightMost.right = root;
                    root = root.left;
                }else if(leftRightMost.right==root){
                    leftRightMost.right = null;
                    ans.add(root.val);
                    root = root.right;
                }
            }
        }
        return ans;
    }
    
    private TreeNode getLeftRightMost(TreeNode node) {
        TreeNode leftRightMost = node.left;
        while(leftRightMost.right!=null && leftRightMost.right!=node){
            leftRightMost = leftRightMost.right;
        }
        return leftRightMost;
    }
    
    // Recursive Solution
    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        helper(root, ans);
        return ans;
    }
    public void helper(TreeNode root, List<Integer> ans) {
        if(root==null){
            return;
        }
        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);
    }*/
}