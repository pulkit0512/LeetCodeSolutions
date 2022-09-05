/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        List<Integer> level = new ArrayList<>();
        
        while(!que.isEmpty()) {
            Node cur = que.poll();
            if(cur==null) {
                result.add(level);
                if(!que.isEmpty()){
                    que.add(null);
                    level = new ArrayList<>();
                }
                continue;
            }
            
            level.add(cur.val);
            for(Node x:cur.children){
                que.add(x);
            }
        }
        
        return result;
    }
}