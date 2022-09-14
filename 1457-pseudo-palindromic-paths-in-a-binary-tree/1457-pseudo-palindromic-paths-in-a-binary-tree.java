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
        int[] arr = new int[10];
        pseudoPalindromicPathsUtil(root, arr);
        return count;
    }
    
    private void pseudoPalindromicPathsUtil(TreeNode node, int[] arr) {
        if(node==null){
            return;
        }
        
        // If node is a leaf
        if(node.left==null && node.right==null){
            arr[node.val]++;
            int odd = 0;
            for(int i=1;i<10;i++){
                if(arr[i]%2==1){
                    odd++;
                }
            }
            if(odd<=1){
                count++;
            }
            arr[node.val]--;
            return;
        }
        
        arr[node.val]++;
        pseudoPalindromicPathsUtil(node.left, arr);
        pseudoPalindromicPathsUtil(node.right, arr);
        arr[node.val]--;
    }
}