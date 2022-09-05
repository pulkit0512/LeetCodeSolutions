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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Key: verLevel, Value: List<Pair<horLevel, node.val>>
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        
        // Pair<TreeNode, verLevel, horLevel>
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> que = new LinkedList<>();
        que.add(new Pair(root, new Pair(0,0)));
        que.add(null);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int horLevel = 0;
        while(!que.isEmpty()){
            Pair<TreeNode, Pair<Integer, Integer>> cur = que.poll();
            if(cur==null){
                horLevel++;
                if(!que.isEmpty()){
                    que.add(null);
                }
                continue;
            }
            int verLevel = cur.getValue().getKey();
            TreeNode node = cur.getKey();
            if(!map.containsKey(verLevel)){
                map.put(verLevel, new ArrayList<>());
            }
            
            map.get(verLevel).add(new Pair(horLevel, node.val));
            min = Math.min(min, verLevel);
            max = Math.max(max, verLevel);
            
            if(node.left!=null){
                que.add(new Pair(node.left, new Pair(verLevel-1, horLevel)));
            }
            
            if(node.right!=null){
                que.add(new Pair(node.right, new Pair(verLevel+1, horLevel)));
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=min;i<=max;i++){
            List<Pair<Integer, Integer>> cur = map.get(i);
            Collections.sort(cur, (a,b)-> {
                if(a.getKey().equals(b.getKey())) {
                    return a.getValue() - b.getValue();
                }else{
                    return a.getKey() - b.getKey();
                }
            });
            List<Integer> curLevel = new ArrayList<>();
            for(Pair<Integer, Integer> pair:cur) {
                curLevel.add(pair.getValue());
            }
            result.add(curLevel);
        }
        
        return result;
    }
}