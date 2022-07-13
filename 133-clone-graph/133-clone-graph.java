/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        map.put(node, new Node(node.val));
        que.add(node);
        while(!que.isEmpty()){
            Node temp = que.poll();
            Node cloneTemp = map.get(temp);
            for(Node neigh:temp.neighbors){
                Node cloneNeigh = map.get(neigh);
                if(cloneNeigh==null){
                    que.add(neigh);
                    cloneNeigh = new Node(neigh.val);
                    map.put(neigh, cloneNeigh);
                }
                cloneTemp.neighbors.add(cloneNeigh);
            }
        }
        return map.get(node);
    }
}