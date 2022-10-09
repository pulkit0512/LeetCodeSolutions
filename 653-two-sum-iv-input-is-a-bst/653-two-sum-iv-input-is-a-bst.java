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
    Set<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        //set = new HashSet<>();
        //return helperUsingInOrderDFS(root, k);
        
        return findTargetUsingInorder(root, k);
    }
    
    private boolean findTargetUsingInorder(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<>();
        inorder(root, sortedList);
        int st = 0, ed = sortedList.size()-1;
        while(st<ed){
            int sum = sortedList.get(st) + sortedList.get(ed);
            if(sum==k){
                return true;
            }else if(sum>k){
                ed--;
            }else{
                st++;
            }
        }
        return false;
    }
    
    private void inorder(TreeNode node, List<Integer> sortedList) {
        if(node==null){
            return;
        }
        
        inorder(node.left, sortedList);
        sortedList.add(node.val);
        inorder(node.right, sortedList);
    }
    
    private boolean helperUsingInOrderDFS(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        boolean left = helperUsingInOrderDFS(root.left, k);
        if(left){
            return true;
        }
        if(set.contains(k-root.val)){
            return true;
        }else{
            set.add(root.val);
        }
        boolean right = helperUsingInOrderDFS(root.right, k);
        if(right){
            return true;
        }
        return false;
    }
}