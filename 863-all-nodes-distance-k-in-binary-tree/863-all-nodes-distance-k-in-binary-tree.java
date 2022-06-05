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
    List<Integer> ans;
    int dist;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        dist = 0;
        kFar(root, target, k);
        return ans;
    }
    
    private boolean kFar(TreeNode root, TreeNode target, int k){
        if(root==null){
            return false;
        }
        if(root==target){
            kDown(root, null, k);
            dist++;
            return true;
        }else if(kFar(root.left, target, k)){
            kDown(root, root.left, k-dist);
            dist++;
            return true;
        }else if(kFar(root.right, target, k)){
            kDown(root, root.right, k-dist);
            dist++;
            return true;
        }else{
            return false;
        }
    }
    
    private void kDown(TreeNode root, TreeNode target, int k){
        if(root==null || root==target){
            return;
        }
        if(k==0){
            ans.add(root.val);
            return;
        }
        kDown(root.left, target, k-1);
        kDown(root.right, target, k-1);
    }
}