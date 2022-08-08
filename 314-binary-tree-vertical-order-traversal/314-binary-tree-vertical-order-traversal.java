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
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        Queue<Pair<Integer, TreeNode>> que = new LinkedList<>();
        int minLevel = 0, maxLevel = 0;
        que.add(new Pair(0, root));
        while(!que.isEmpty()){
            Pair<Integer, TreeNode> cur = que.poll();
            minLevel = Math.min(minLevel, cur.getKey());
            maxLevel = Math.max(maxLevel, cur.getKey());
            
            if(!levelMap.containsKey(cur.getKey())){
                levelMap.put(cur.getKey(), new ArrayList<>());
            }
            levelMap.get(cur.getKey()).add(cur.getValue().val);
            if(cur.getValue().left!=null){
                que.add(new Pair(cur.getKey()-1, cur.getValue().left));
            }
            if(cur.getValue().right!=null){
                que.add(new Pair(cur.getKey()+1, cur.getValue().right));
            }
        }
        for(int i=minLevel;i<=maxLevel;i++){
            result.add(levelMap.get(i));
        }
        return result;
    }
}