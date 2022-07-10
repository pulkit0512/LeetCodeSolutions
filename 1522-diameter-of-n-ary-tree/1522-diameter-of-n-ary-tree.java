/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int diameter;
    public int diameter(Node root) {
        diameter = 0;
        diameterUtil(root);
        return diameter;
    }
    
    private int diameterUtil(Node root) {
        if(root==null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        for(int i=0;i<root.children.size();i++){
            int val = diameterUtil(root.children.get(i));
            if(val>max){
                secMax = max;
                max = val;
            }else if(val>secMax){
                secMax = val;
            }
        }
        diameter = Math.max(diameter, max + secMax);
        return max+1;
    }
}