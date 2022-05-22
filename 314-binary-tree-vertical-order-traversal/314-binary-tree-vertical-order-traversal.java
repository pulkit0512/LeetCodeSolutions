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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Map<Integer, List<Integer>> tempAns = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> que = new LinkedList<>();
        int min = 0, max = 0;
        que.add(new Pair(root, 0));
        while(!que.isEmpty()){
            Pair<TreeNode, Integer> parent = que.poll();
            TreeNode parentNode = parent.getKey();
            int parentLevel = parent.getValue();
            if(!tempAns.containsKey(parentLevel)){
                tempAns.put(parentLevel, new ArrayList<>());
            }
            tempAns.get(parentLevel).add(parentNode.val);
            if(parentNode.left!=null){
                que.add(new Pair(parentNode.left, parentLevel-1));
                min = Math.min(min, parentLevel-1);
            }
            if(parentNode.right!=null){
                que.add(new Pair(parentNode.right, parentLevel+1));
                max = Math.max(max, parentLevel+1);
            }
        }
        for(int i=min;i<=max;i++){
            ans.add(tempAns.get(i));
        }
        return ans;
    }
}