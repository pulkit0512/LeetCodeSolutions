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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        TreeNode LCA = null, childNode = null;
        boolean oneNodeFound = false;
        st.push(new Pair(root, BOTH_PENDING));
        while(!st.isEmpty()){
            TreeNode parent = st.peek().getKey();
            int parentState = st.peek().getValue();
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
                st.push(new Pair(parent, parentState-1));
                if(childNode!=null){
                    st.push(new Pair(childNode, BOTH_PENDING));
                }
            }else{
                if(LCA == st.pop().getKey() && oneNodeFound){
                    if(!st.isEmpty()){
                        LCA = st.peek().getKey();
                    }
                }
            }
        }
        return null;
    }
}