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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return buildTreeUtil(preorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode buildTreeUtil(int[] preorder, int ps, int pe, int is, int ie) {
        if(is>ie){
            return null;
        }
        int idx = map.get(preorder[ps]);
        int left = idx - is;
        TreeNode node = new TreeNode(preorder[ps]);
        node.left = buildTreeUtil(preorder, ps+1, ps+left, is, idx-1);
        node.right = buildTreeUtil(preorder, ps+left+1, pe, idx+1, ie);
        
        return node;
    }
}