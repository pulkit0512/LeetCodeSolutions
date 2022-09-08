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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        while(root!=null){
            if(root.left==null){
                result.add(root.val);
                root = root.right;
            }else{
                TreeNode rootLeftRightmost = getLeftRightmost(root);
                if(rootLeftRightmost.right==null){
                    rootLeftRightmost.right = root;
                    root = root.left;
                }else if(rootLeftRightmost.right==root){
                    rootLeftRightmost.right = null;
                    result.add(root.val);
                    root = root.right;
                }
            }
        }
        return result;
    }
    
    private TreeNode getLeftRightmost(TreeNode root) {
        TreeNode node = root.left;
        while(node.right!=null && node.right!=root){
            node = node.right;
        }
        return node;
    }
}