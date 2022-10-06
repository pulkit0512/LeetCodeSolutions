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
    int count;
    Map<Long, Integer> map;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        count = 0;
        map.put(0L, 1);
        pathSumUtil(root, targetSum, 0);
        return count;
    }
    
    private void pathSumUtil(TreeNode root, int targetSum, long sum) {
        if(root==null){
            return;
        }
        
        sum += root.val;
        
        count += map.getOrDefault(sum-targetSum, 0);
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        pathSumUtil(root.left, targetSum, sum);
        pathSumUtil(root.right, targetSum, sum);
        
        map.put(sum, map.getOrDefault(sum, 0) - 1);
        sum -= root.val;
    }
}