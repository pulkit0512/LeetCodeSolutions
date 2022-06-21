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
        return inorderSuccessorUsingInOrderBT(root, p);
        
        //return inorderSuccessorUsingBSTProperties(root, p);
    }
    
    private TreeNode inorderSuccessorUsingBSTProperties(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while(root!=null){
            if(p.val>=root.val){
                root = root.right;
            }else{
                ans = root;
                root = root.left;
            }
        }
        return ans;
    }
    
    private TreeNode inorderSuccessorUsingInOrderBT(TreeNode root, TreeNode p) {
        List<TreeNode> inorder = new ArrayList<>();
        return helper(root, p, inorder);
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
        return right;
    }
}