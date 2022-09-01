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
    class Pair {
        TreeNode node;
        int max;
        
        public Pair(TreeNode node, int max) {
            this.node = node;
            this.max = max;
        }
    }
    
    int nodes;
    public int goodNodes(TreeNode root) {
        //nodes = 0;
        //goodNodesDFSUtil(root, Integer.MIN_VALUE);
        //return nodes;
        
        return goodNodesBFSUtil(root);
    }
    
    private int goodNodesBFSUtil(TreeNode root) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root, Integer.MIN_VALUE));
        nodes = 0;
        
        while(!que.isEmpty()) {
            Pair cur = que.poll();
            int max = cur.max;
            TreeNode node = cur.node;
            
            if(node.val>=max){
                nodes++;
                max = node.val;
            }
            
            if(node.left!=null){
                que.add(new Pair(node.left, max));
            }
            
            if(node.right!=null){
                que.add(new Pair(node.right, max));
            }
        }
        
        return nodes;
    }
    
    private void goodNodesDFSUtil(TreeNode root, int max) {
        if(root==null){
            return;
        }
        if(root.val>=max){
            nodes++;
        }
        max = Math.max(max, root.val);
        
        goodNodesDFSUtil(root.left, max);
        goodNodesDFSUtil(root.right, max);
    }
}