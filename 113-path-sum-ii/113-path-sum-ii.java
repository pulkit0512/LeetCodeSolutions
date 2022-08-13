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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root==null){
            return result;
        }
        pathSumUtil(root, targetSum, new ArrayList<>());
        return result;
    }
    
    private void pathSumUtil(TreeNode root, int targetSum, List<Integer> cur) {
        cur.add(root.val);
        targetSum -= root.val;
        //System.out.println(cur + " " + targetSum);
        if(root.left==null && root.right==null && targetSum==0){
            result.add(new ArrayList<>(cur));
        }
        if(root.left!=null){
            pathSumUtil(root.left, targetSum, cur);
        }
        if(root.right!=null){
            pathSumUtil(root.right, targetSum, cur);
        }
        targetSum += cur.get(cur.size()-1);
        cur.remove(cur.size()-1);
    }
}