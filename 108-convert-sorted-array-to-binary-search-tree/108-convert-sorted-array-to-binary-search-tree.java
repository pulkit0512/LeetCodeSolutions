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
        return sortedArrayToBstUtil(nums, 0, nums.length-1);
    }
    
    private TreeNode sortedArrayToBstUtil(int[] nums, int st, int ed) {
        if(ed<st){
            return null;
        }
        
        int mid = (st+ed)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBstUtil(nums, st, mid-1);
        root.right = sortedArrayToBstUtil(nums, mid+1, ed);
        return root;
    }
}