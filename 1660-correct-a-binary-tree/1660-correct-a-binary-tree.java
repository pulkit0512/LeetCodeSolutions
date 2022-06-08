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
    public TreeNode correctBinaryTree(TreeNode root) {
        // Node Vs Parent map
        Map<TreeNode, TreeNode> nodeMap = new LinkedHashMap<>();
        nodeMap.put(root, null);
        TreeNode invalid = null, invalidParent = null;
        while(!nodeMap.isEmpty()){
            TreeNode curNode = nodeMap.entrySet().iterator().next().getKey();
            TreeNode parent = nodeMap.get(curNode);
            nodeMap.remove(curNode);
            if(curNode.left!=null){
                nodeMap.put(curNode.left, curNode);
            }
            if(curNode.right!=null){
                if(nodeMap.containsKey(curNode.right)){
                    invalid = curNode;
                    invalidParent = parent;
                    break;
                }else{
                    nodeMap.put(curNode.right, curNode);
                }
            }
        }
        if(invalidParent.left==invalid){
            invalidParent.left = null;
        }else{
            invalidParent.right = null;
        }
        return root;
    }
}