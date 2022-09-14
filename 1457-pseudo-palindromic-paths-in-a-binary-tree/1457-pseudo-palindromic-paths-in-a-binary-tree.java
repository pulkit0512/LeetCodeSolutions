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
    int count;
    public int pseudoPalindromicPaths (TreeNode root) {
        count = 0;
        pseudoPalindromicPathsUtil(root, 0);
        return count;
    }
    
    private void pseudoPalindromicPathsUtil(TreeNode node, int bits) {
        if(node==null){
            return;
        }
        
        // If node is a leaf
        if(node.left==null && node.right==null){
            bits = bits ^ (1<<node.val);
            
            if(getSetBits(bits)<=1){
                count++;
            }
            
            bits = bits ^ (1<<node.val);
            return;
        }
        
        bits = bits ^ (1<<node.val);
        pseudoPalindromicPathsUtil(node.left, bits);
        pseudoPalindromicPathsUtil(node.right, bits);
        bits = bits ^ (1<<node.val);
    }
    
    private int getSetBits(int n) {
        int cnt = 0;
        while(n>0){
            n = n&(n-1);
            cnt++;
        }
        return cnt;
    }
}