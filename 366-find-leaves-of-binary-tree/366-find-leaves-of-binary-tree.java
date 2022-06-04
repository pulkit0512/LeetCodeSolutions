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
    List<List<Integer>> ans;
    public List<List<Integer>> findLeaves(TreeNode root) {
        ans = new ArrayList<>();
        findLeavesUtil(root, 0);
        return ans;
    }
    
    private int findLeavesUtil(TreeNode root, int leafLevel) {
        if(root==null){
            return 0;
        }
        int left = findLeavesUtil(root.left, leafLevel);
        int right = findLeavesUtil(root.right, leafLevel);
        int level = Math.max(left, right) + 1;
        if(ans.size()<level){
            ans.add(new ArrayList<>());
        }
        ans.get(level-1).add(root.val);
        return level;
    }
}