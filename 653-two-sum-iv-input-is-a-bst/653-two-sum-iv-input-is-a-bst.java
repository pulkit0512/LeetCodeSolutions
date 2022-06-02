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
        bstInorder(root, sortedList);
        int st = 0, ed = sortedList.size()-1;
        while(st<ed){
            if(sortedList.get(st) + sortedList.get(ed) == k){
                return true;
            }else if(sortedList.get(st) + sortedList.get(ed)<k){
                st++;
            }else{
                ed--;
            }
        }
        return false;
    }
    
    private void bstInorder(TreeNode root, List<Integer> sortedList){
        if(root==null){
            return;
        }
        bstInorder(root.left, sortedList);
        sortedList.add(root.val);
        bstInorder(root.right, sortedList);
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