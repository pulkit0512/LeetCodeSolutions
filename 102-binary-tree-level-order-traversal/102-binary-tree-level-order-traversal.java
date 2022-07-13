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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        while(!que.isEmpty()){
            TreeNode temp = que.poll();
            if(temp==null){
                if(!que.isEmpty()){
                    que.add(null);
                }
                result.add(level);
                level = new ArrayList<>();
                continue;
            }
            level.add(temp.val);
            if(temp.left!=null){
                que.add(temp.left);
            }
            if(temp.right!=null){
                que.add(temp.right);
            }
        }
        return result;
    }
}