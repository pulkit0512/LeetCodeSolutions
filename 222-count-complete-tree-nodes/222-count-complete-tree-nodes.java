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
    public int countNodes(TreeNode root) {
        // Using BFS time complexity O(N) on average
        //return countNodesBFS(root);
        
        // Using DFS time complexity less than O(N) on average checks if a subtree is complete or not
        // If a subtree is complete we don't need to traverse all the nodes
        // so time complexity is less than O(N)
        //return countNodesDFS(root);
        
        // Using Binary Search, complexity will be (logN)^2
        return countNodesBinarySearch(root);
    }
    
    private int countNodesBinarySearch(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int d = getDepth(root);
        if(d==0){
            return 1;
        }
        int nodes = (int)Math.pow(2, d) - 1;
        
        int left = 1, right = nodes;
        while(left<=right){
            int mid = (left+right)/2;
            
            if(exists(mid, d, root)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return nodes + left;
    }
    
    private int getDepth(TreeNode root) {
        int depth = 0;
        while(root.left!=null){
            depth++;
            root=root.left;
        }
        return depth;
    }
    
    private boolean exists(int idx, int d, TreeNode root) {
        int left = 0, right = (int)Math.pow(2, d)-1;
        for(int i=0;i<d;i++){
            int mid = (left+right)/2;
            if(idx<=mid){
                root = root.left;
                right = mid;
            }else{
                root = root.right;
                left = mid+1;
            }
        }
        
        return root!=null;
    }
    
    private int countNodesDFS(TreeNode root){
        if(root==null){
            return 0;
        }
        TreeNode left = root, right = root;
        int c_left = 0, c_right = 0;
        while(left!=null){
            left = left.left;
            c_left++;
        }
        while(right!=null){
            right = right.right;
            c_right++;
        }
        if(c_left==c_right){
            return (int)Math.pow(2, c_left) - 1;
        }
        return 1 + countNodesDFS(root.left) + countNodesDFS(root.right);
    }
    private int countNodesBFS(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int ans = 1;
        while(true){
            TreeNode temp = que.poll();
            if(temp.left!=null){
                que.add(temp.left);
                ans++;
            }else{
                break;
            }
            if(temp.right!=null){
                que.add(temp.right);
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
}