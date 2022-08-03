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
    public int countNodes(TreeNode root) {
        // Using BFS time complexity O(N) on average
        // return countNodesBFS(root);
        
        // Using DFS time complexity less than O(N) on average checks if a subtree is complete or not
        // If a subtree is complete we don't need to traverse all the nodes
        // so time complexity is less than O(N)
        return countNodesDFS(root);
    }
    private int countNodesDFS(TreeNode root){
        if(root==null){
            return 0;
        }
        TreeNode left = root, right = root;
        int c_left = 0, c_right = 0;
        while(left!=null){
            left = left.left;
            c_left++;
        }
        while(right!=null){
            right = right.right;
            c_right++;
        }
        if(c_left==c_right){
            return (int)Math.pow(2, c_left) - 1;
        }
        return 1 + countNodesDFS(root.left) + countNodesDFS(root.right);
    }
    private int countNodesBFS(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int ans = 1;
        while(true){
            TreeNode temp = que.poll();
            if(temp.left!=null){
                que.add(temp.left);
                ans++;
            }else{
                break;
            }
            if(temp.right!=null){
                que.add(temp.right);
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
}