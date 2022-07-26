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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LcaUsingRecursion(root, p, q);
        //return LcaIteratively(root, p, q);
    }
    private TreeNode LcaIteratively(TreeNode root, TreeNode p, TreeNode q){
        int both_done = 0, left_done = 1, both_pending = 2;
        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        boolean oneNodeFound = false;
        TreeNode LCA = null, childNode = null;
        st.push(new Pair<>(root, both_pending));
        while(!st.isEmpty()){
            Pair<TreeNode, Integer> pair = st.peek();
            TreeNode parent = pair.getKey();
            int parentState = pair.getValue();
            if(parentState == both_done){
                if(LCA==st.pop().getKey() && oneNodeFound){
                    LCA = st.peek().getKey();
                }
            }else{
                if(parentState == both_pending) {
                    if(parent == p || parent == q){
                        if(oneNodeFound){
                            return LCA;
                        }else{
                            oneNodeFound = true;
                            LCA = st.peek().getKey();
                        }
                    }
                    childNode = parent.left;
                }else{
                    childNode = parent.right;
                }
                st.pop();
                st.push(new Pair<>(parent, parentState-1));
                if(childNode!=null){
                    st.push(new Pair<>(childNode, both_pending));
                }
            }
        }
        return null;
    }
    private TreeNode LcaUsingRecursion(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root==q){
            return root;
        }
        
        TreeNode llca = LcaUsingRecursion(root.left, p, q);
        TreeNode rlca = LcaUsingRecursion(root.right, p, q);
        
        if(llca!=null && rlca!=null){
            return root;
        }
        
        return llca==null?rlca:llca;
    }
}