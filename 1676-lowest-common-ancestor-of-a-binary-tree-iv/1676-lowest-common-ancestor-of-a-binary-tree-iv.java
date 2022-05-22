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
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        result = null;
        Set<TreeNode> set = new HashSet<>();
        for(TreeNode node:nodes){
            set.add(node);
        }
        lca(root, set);
        return result;
    }
    private int lca(TreeNode root, Set<TreeNode> set) {
        if(root == null){
            return 0;
        }
        if(result!=null){
            return set.size();
        }
        int left = lca(root.left, set);
        int right = lca(root.right, set);
        int mid = set.contains(root) ? 1 : 0;
        int val = right+left+mid;
        if(val>=set.size()){
            if(result==null){
                result = root;
            }
        }
        return val;
    }
}