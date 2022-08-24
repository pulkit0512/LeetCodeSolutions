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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> que = new LinkedList<>();
        que.add(new Pair(root, 0));
        int ans = 0;
        while(!que.isEmpty()){
            int first = que.peek().getValue();
            int last = first;
            for(int i=que.size();i>0;i--){
                Pair<TreeNode, Integer> cur = que.poll();
                last = cur.getValue();
                if(cur.getKey().left!=null){
                    que.add(new Pair(cur.getKey().left, 2*cur.getValue()));
                }
                if(cur.getKey().right!=null){
                    que.add(new Pair(cur.getKey().right, 2*cur.getValue() + 1));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}