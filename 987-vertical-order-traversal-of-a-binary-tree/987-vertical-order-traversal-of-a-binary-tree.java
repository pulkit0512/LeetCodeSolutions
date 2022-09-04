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
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        
        Queue<Pair<TreeNode, Integer>> que = new LinkedList<>();
        que.add(new Pair(root, 0));
        que.add(null);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int horLevel = 0;
        while(!que.isEmpty()){
            Pair<TreeNode, Integer> cur = que.poll();
            if(cur==null){
                horLevel++;
                if(!que.isEmpty()){
                    que.add(null);
                }
                continue;
            }
            int verLevel = cur.getValue();
            TreeNode node = cur.getKey();
            if(!map.containsKey(verLevel)){
                map.put(verLevel, new LinkedHashMap<>());
            }
            if(!map.get(verLevel).containsKey(horLevel)){
                map.get(verLevel).put(horLevel, new ArrayList<>());
            }
            map.get(verLevel).get(horLevel).add(node.val);
            min = Math.min(min, verLevel);
            max = Math.max(max, verLevel);
            
            if(node.left!=null){
                que.add(new Pair(node.left, verLevel-1));
            }
            
            if(node.right!=null){
                que.add(new Pair(node.right, verLevel+1));
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=min;i<=max;i++){
            Map<Integer, List<Integer>> cur = map.get(i);
            List<Integer> curLevel = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> entry:cur.entrySet()) {
                List<Integer> temp = entry.getValue();
                Collections.sort(temp);
                curLevel.addAll(temp);
            }
            result.add(curLevel);
        }
        
        return result;
    }
}