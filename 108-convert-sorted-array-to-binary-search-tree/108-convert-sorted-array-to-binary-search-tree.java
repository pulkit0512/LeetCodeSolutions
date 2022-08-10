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
    public TreeNode sortedArrayToBST(int[] nums) {
        return getBst(nums, 0, nums.length-1);
    }
    
    private TreeNode getBst(int[] nums, int st, int ed){
        if(st>ed){
            return null;
        }
        
        int mid = (st+ed)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = getBst(nums, st, mid-1);
        node.right = getBst(nums, mid+1, ed);
        
        return node;
    }
}