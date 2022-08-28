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
    int longestPath;
    public int longestConsecutive(TreeNode root) {
        longestPath = 0;
        longestConsecutiveUtil(root);
        return longestPath;
    }
    
    // Returns an array containing largest increasing and decreasing lengths upto current node.
    private int[] longestConsecutiveUtil(TreeNode root) {
        if(root==null){
            return new int[]{0, 0};
        }
        
        int[] left = longestConsecutiveUtil(root.left);
        int[] right = longestConsecutiveUtil(root.right);
        
        int inr = 1, dcr = 1;
        if(root.left!=null){
            if(root.left.val==root.val+1){
                inr = left[0]+1;
            }else if(root.left.val==root.val-1){
                dcr = left[1]+1;
            }
        }
        
        if(root.right!=null){
            if(root.right.val==root.val+1){
                inr = Math.max(inr, right[0]+1);
            }else if(root.right.val==root.val-1){
                dcr = Math.max(dcr, right[1]+1);
            }
        }
        
        longestPath = Math.max(longestPath, inr+dcr-1);
        return new int[]{inr, dcr};
    }
}