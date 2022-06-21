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
        int n = inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, n-1, 0, n-1);
    }
    private TreeNode buildTreeHelper(int[] preorder, int ps, int pe, int is, int ie) {
        if(is>ie || ps>pe){
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int idx = map.get(preorder[ps]);
        int left = idx-is;
        root.left = buildTreeHelper(preorder, ps+1, ps+left, is, idx-1);
        root.right = buildTreeHelper(preorder, ps+left+1, pe, idx+1, ie);
        return root;
    }
    
}