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
    public int kthSmallest(TreeNode root, int k) {
        while(root!=null){
            if(root.left==null){
                k--;
                if(k==0){
                    break;
                }
                root = root.right;
            }else{
                TreeNode leftRightMost = getLeftRightMost(root);
                if(leftRightMost.right==null){
                    leftRightMost.right = root;
                    root = root.left;
                }else if(leftRightMost.right == root) {
                    leftRightMost.right = null;
                    k--;
                    if(k==0){
                        break;
                    }
                    root = root.right;
                }
            }
        }
        return root.val;
    }
    
    private TreeNode getLeftRightMost(TreeNode root) {
        TreeNode leftRightMost = root.left;
        while(leftRightMost.right!=null  && leftRightMost.right!=root){
            leftRightMost = leftRightMost.right;
        }
        return leftRightMost;
    }
}