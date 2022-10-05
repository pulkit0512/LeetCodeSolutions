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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        
        Queue<TreeNode> que = new LinkedList<>();
        int curDepth = 1;
        que.add(root);
        que.add(null);
        
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            
            if(node==null){
                if(!que.isEmpty()){
                    que.add(null);
                }
                curDepth++;
                continue;
            }
            
            //System.out.println(curDepth +" "+ node.val);
            
            if(node.left!=null){
                que.add(node.left);
            }
            if(node.right!=null){
                que.add(node.right);
            }
            
            if(curDepth==depth-1){
                TreeNode newNodeLeft = new TreeNode(val);
                newNodeLeft.left = node.left;
                node.left = newNodeLeft;
                
                TreeNode newNodeRight = new TreeNode(val);
                newNodeRight.right = node.right;
                node.right = newNodeRight;
            }
        }
        
        return root;
    }
}