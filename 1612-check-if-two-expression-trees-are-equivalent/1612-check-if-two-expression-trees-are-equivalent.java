/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Character, Integer> map;
    public boolean checkEquivalence(Node root1, Node root2) {
        map = new HashMap<>();
        createMap(root1);
        return isEquivalent(root2);
    }
    
    private void createMap(Node root) {
        if(root==null){
            return;
        }
        if(!map.containsKey(root.val)){
            map.put(root.val, 1);
        }else{
            map.put(root.val, map.get(root.val)+1);
        }
        createMap(root.left);
        createMap(root.right);
    }
    
    private boolean isEquivalent(Node root) {
        if(root==null){
            return true;
        }
        if(!map.containsKey(root.val)){
            return false;
        }else{
            int k = map.get(root.val);
            if(k==1){
                map.remove(root.val);
            }else{
                map.put(root.val, k-1);
            }
        }
        boolean left = isEquivalent(root.left);
        if(!left){
            return false;
        }
        boolean right = isEquivalent(root.right);
        return right;
    }
}