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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        que.add(root);
        que.add(null);
        while(!que.isEmpty()){
            TreeNode temp = que.poll();
            if(temp==null){
                if(!que.isEmpty()){
                    que.add(null);
                }
                continue;
            }
            if(que.peek()==null){
                res.add(temp.val);
            }
            if(temp.left!=null){
                que.add(temp.left);
            }
            if(temp.right!=null){
                que.add(temp.right);
            }
        }
        return res;
    }
}