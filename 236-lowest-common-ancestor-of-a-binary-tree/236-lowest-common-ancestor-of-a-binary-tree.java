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
        //return LcaUsingRecursion(root, p, q);
        return LcaIteratively(root, p, q);
    }
    private TreeNode LcaIteratively(TreeNode root, TreeNode p, TreeNode q){
        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        int bothPending = 0, leftDone = 1, bothDone = 2;
        TreeNode LCA = null;
        boolean oneNodeFound = false;
        st.push(new Pair<>(root, bothPending));
        while(!st.isEmpty()){
            Pair<TreeNode, Integer> peekNode = st.peek();
            TreeNode parent = peekNode.getKey();
            int state = peekNode.getValue();
            if(state==bothDone){
                if(LCA == st.pop().getKey() && oneNodeFound){
                    LCA = st.peek().getKey();
                }
            }else{
                TreeNode child = null;
                if(state==bothPending){
                    if(parent==p || parent==q){
                        if(oneNodeFound) {
                             return LCA;
                        }else{
                            oneNodeFound = true;
                            LCA = st.peek().getKey();
                        }
                    }
                    child = parent.left;
                }else{
                    child = parent.right;
                }
                st.pop();
                st.push(new Pair<>(parent, state+1));
                if(child!=null){
                    st.push(new Pair<>(child, bothPending));
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