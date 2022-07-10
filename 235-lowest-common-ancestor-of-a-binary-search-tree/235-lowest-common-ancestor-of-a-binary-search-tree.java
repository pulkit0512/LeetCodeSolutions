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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //return lowestCommonAncestorBT(root, p, q);
        return lowestCommonAncestorBST(root, p, q);
    }
    
    private TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val>p.val && root.val>q.val){
                root = root.left;
            }else if(root.val<p.val && root.val<q.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return null;
    }
    
    private TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }
        
        TreeNode llca = lowestCommonAncestor(root.left, p, q);
        TreeNode rlca = lowestCommonAncestor(root.right, p, q);
        if(llca!=null && rlca!=null){
            return root;
        }
        
        return llca!=null?llca:rlca;
    }
}