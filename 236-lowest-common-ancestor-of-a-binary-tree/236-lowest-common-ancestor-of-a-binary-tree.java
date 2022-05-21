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
        int bothDone = 0, leftDone = 1, bothPending = 2;
        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        TreeNode LCA = null, childNode = null;
        boolean oneNodeFound = false;
        st.push(new Pair(root, bothPending));
        while(!st.isEmpty()){
            Pair<TreeNode, Integer> temp = st.peek();
            TreeNode parent = temp.getKey();
            int parentState = temp.getValue();
            if(parentState!=bothDone){
                if(parentState==bothPending){
                    if(parent.val==p.val || parent.val==q.val){
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
                st.push(new Pair(parent, parentState-1));
                if(childNode !=null){
                    st.push(new Pair(childNode, bothPending));
                }
            } else{
                if(LCA == st.pop().getKey() && oneNodeFound){
                    LCA = st.peek().getKey();
                }
            }
        }
        return null;
    }
    private TreeNode LcaUsingRecursion(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        if(root.val==p.val || root.val==q.val){
            return root;
        }
        TreeNode llca = lowestCommonAncestor(root.left, p, q);
        TreeNode rlca = lowestCommonAncestor(root.right, p, q);
        
        if(llca!=null && rlca!=null){
            return root;
        }
        return llca!=null?llca:rlca;
    }
}