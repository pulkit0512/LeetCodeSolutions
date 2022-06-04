/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode root;
    int last;
    int pre[];
    public TreeNode bstFromPreorder(int[] preorder) {
        //return bstFromPreorderUsingLastPointerAndMaxLimit(preorder);
        //return bstFromPreorderUsingValidateBSTTechnique(preorder);
        return bstFromPreorderIteratively(preorder);
    }
    
    private TreeNode bstFromPreorderIteratively(int[] pre) {
        if(pre.length==0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        Deque<TreeNode> dq = new LinkedList<>();
        dq.push(root);
        for(int i=1;i<pre.length;i++){
            TreeNode parent = dq.peek();
            TreeNode child = new TreeNode(pre[i]);
            while(!dq.isEmpty() && dq.peek().val<child.val){
                parent = dq.removeFirst();
            }
            if(parent.val<child.val){
                parent.right=child;
            }else{
                parent.left=child;
            }
            dq.addFirst(child);
        }
        return root;
    }
    
    private TreeNode bstFromPreorderUsingValidateBSTTechnique(int[] pre) {
        last = 0;
        this.pre = pre;
        return getBst2(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode getBst2(int min, int max) {
        if(last==pre.length){
            return null;
        }
        int val = pre[last];
        if(val<min || val>max){
            return null;
        }
        last++;
        TreeNode root = new TreeNode(val);
        root.left = getBst2(min, val);
        root.right = getBst2(val, max);
        return root;
    }
    
    private TreeNode bstFromPreorderUsingLastPointerAndMaxLimit(int[] preorder) {
        last = 0;
        getBst(preorder, 0, Integer.MAX_VALUE);
        return root;
    }
    
    private TreeNode getBst(int pre[], int idx, int max) {
        TreeNode node = new TreeNode(pre[idx]);
        if(root==null){
            root=node;
        }
        if(last+1<pre.length && pre[last+1]<pre[idx]){
            last++;
            node.left = getBst(pre, last, pre[idx]);
        }
        if(last+1<pre.length && pre[last+1]>pre[idx] && pre[last+1]<max){
            last++;
            node.right = getBst(pre, last, max);
        }
        return node;
    }
}