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
    public void flatten(TreeNode root) {
        //flattenUtil(root);
        flattenUtilConstantSpace(root);
    }
    
    private void flattenUtilConstantSpace(TreeNode root) {
        while(root!=null){
            if(root.left!=null){
                TreeNode left = root.left;
                while(left.right!=null){
                    left = left.right;
                }
                left.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
    
    private TreeNode flattenUtil(TreeNode root) {
        if(root==null){
            return null;
        }
        
        // leaf node return as it is.
        if(root.left==null && root.right==null){
            return root;
        }
        
        // Get tail from both subtrees
        TreeNode leftTail = flattenUtil(root.left);
        TreeNode rightTail = flattenUtil(root.right);
        
        //Left tail not null, leftTail right will become root.right.
        //root.left will become root.right and set root.left to null
        if(leftTail!=null){
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        //Return the rightmost node as tail.
        return rightTail==null ? leftTail : rightTail;
    }
}