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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();
        findLeavesUtil(root, leaves);
        return leaves;
    }
    
    private int findLeavesUtil(TreeNode root, List<List<Integer>> leaves) {
        if(root==null){
            return 0;
        }
        int left = findLeavesUtil(root.left, leaves);
        int right = findLeavesUtil(root.right, leaves);
        
        int cur = Math.max(left, right);
        if(leaves.size()<=cur){
            leaves.add(new ArrayList<>());
        }
        leaves.get(cur).add(root.val);
        return cur + 1;
    }
}