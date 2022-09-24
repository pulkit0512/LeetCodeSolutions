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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        pathSumUtil(root, targetSum, new ArrayList<>());
        return res;
    }
    
    private void pathSumUtil(TreeNode root, int targetSum, List<Integer> cur) {
        if(root==null){
            return;
        }
        
        cur.add(root.val);
        targetSum -= root.val;
        if(root.left==null && root.right==null){
            if(targetSum==0){
                res.add(new ArrayList<>(cur));
            }
        }else{
            pathSumUtil(root.left, targetSum, cur);
            pathSumUtil(root.right, targetSum, cur);
        }
        cur.remove(cur.size()-1);
        targetSum += root.val;
    }
}