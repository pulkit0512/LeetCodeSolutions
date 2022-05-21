/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private static final int BOTH_DONE = 0;
    private static final int LEFT_DONE = 1;
    private static final int BOTH_PENDING = 2;
    class pair{
        TreeNode key;
        int val;
        pair(TreeNode a, int b){
            key = a;
            val = b;
        }
    }
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //return LcaIteratively(root, p, q);
        
        result = null;
        LcaRecursively(root, p, q);
        return result;
    }
    private TreeNode LcaIteratively(TreeNode root, TreeNode p, TreeNode q) {
        Stack<pair> st = new Stack<>();
        TreeNode LCA = null, childNode = null;
        boolean oneNodeFound = false;
        st.push(new pair(root, BOTH_PENDING));
        while(!st.isEmpty()){
            TreeNode parent = st.peek().key;
            int parentState = st.peek().val;
            if(parentState!=BOTH_DONE){
                if(parentState==BOTH_PENDING){
                    if(parent.val==p.val || parent.val==q.val){
                        if(oneNodeFound){
                            return LCA;
                        }else{
                            oneNodeFound = true;
                            LCA = parent;
                        }
                    }
                    childNode = parent.left;
                }else{
                    childNode = parent.right;
                }
                st.pop();
                st.push(new pair(parent, parentState-1));
                if(childNode!=null){
                    st.push(new pair(childNode, BOTH_PENDING));
                }
            }else{
                if(LCA == st.pop().key && oneNodeFound){
                    if(!st.isEmpty()){
                        LCA = st.peek().key;
                    }
                }
            }
        }
        return null;
    }
    private int LcaRecursively(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return 0;
        }
        int left = LcaRecursively(root.left, p, q);
        int right = LcaRecursively(root.right, p, q);
        int count = left+right;
        if(root.val==p.val || root.val==q.val){
            count++;
        }
        if(count==2){
            result = root;
        }
        return (count>0)?1:0;
    }
}