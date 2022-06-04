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
        createMap(root1, 1);
        return isEquivalent(root2, 1);
    }
    
    private void createMap(Node root, int sign) {
        if(root==null){
            return;
        }
        if(root.val=='+'){
            createMap(root.left, sign);
            createMap(root.right, sign);
        }else if(root.val=='-'){
            createMap(root.left, sign);
            createMap(root.right, -sign);
        }else{
            char key = root.val;
            if(sign==-1){
                key = (char)(key - 'a' + 'A');
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }
    
    private boolean isEquivalent(Node root, int sign) {
        if(root==null){
            return true;
        }
        if(root.val=='+'){
            boolean left = isEquivalent(root.left, sign);
            if(!left){
                return false;
            }
            return isEquivalent(root.right, sign);
        }else if(root.val=='-'){
            boolean left = isEquivalent(root.left, sign);
            if(!left){
                return false;
            }
            return isEquivalent(root.right, -sign);
        }else{
            char key = root.val;
            if(sign==-1){
                key = (char)(key - 'a' + 'A');
            }
            if(!map.containsKey(key)){
                return false;
            }
            int k = map.get(key);
            if(k==1){
                map.remove(key);
            }else{
                map.put(key, k-1);
            }
            return true;
        }
    }
}