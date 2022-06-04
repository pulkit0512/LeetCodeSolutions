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
    int[] map;
    public boolean checkEquivalence(Node root1, Node root2) {
        map = new int[5000];
        createMap(root1);
        return isEquivalent(root2);
    }
    
    private void createMap(Node root) {
        if(root==null){
            return;
        }
        if(root.val=='+'){
            map[0]++;
        }else{
            map[root.val-'a']++;
        }
        createMap(root.left);
        createMap(root.right);
    }
    
    private boolean isEquivalent(Node root) {
        if(root==null){
            return true;
        }
        if((root.val=='+' && map[0]==0) || (root.val!='+' && map[root.val-'a']==0)){
            return false;
        }
        if(root.val=='+'){
            map[0]--;
        }else{
            map[root.val-'a']--;
        }
        boolean left = isEquivalent(root.left);
        if(!left){
            return false;
        }
        boolean right = isEquivalent(root.right);
        return right;
    }
}