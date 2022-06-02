/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> inOrder = new ArrayList<>();
        return helper(root, p, inOrder);
    }
    
    private TreeNode helper(TreeNode root, TreeNode p, List<TreeNode> inOrder){
        if(root==null){
            return null;
        }
        TreeNode left = helper(root.left, p, inOrder);
        if(left!=null){
            return left;
        }
        
        if(!inOrder.isEmpty() && inOrder.get(inOrder.size()-1)==p){
            return root;
        }
        inOrder.add(root);
        
        TreeNode right = helper(root.right, p, inOrder);
        return right!=null?right:null;
    }
}