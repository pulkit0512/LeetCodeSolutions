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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //return zigzagLevelOrderUsingTwoStacks(root);
        return zigzagLevelOrderUsingDeque(root);
    }
    
    private List<List<Integer>> zigzagLevelOrderUsingDeque(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        
        Deque<TreeNode> deque = new LinkedList<>();
        int level = 0;
        deque.addLast(root);
        deque.addLast(null);
        List<Integer> list = new ArrayList<>();
        while(!deque.isEmpty()) {
            if(level%2==0){
                TreeNode cur = deque.pollFirst();
                if(cur==null){
                    ans.add(new ArrayList<>(list));
                    if(!deque.isEmpty()){
                        deque.addFirst(null);
                        level++;
                        list = new ArrayList<>();
                    }
                    continue;
                }
                
                list.add(cur.val);
                
                if(cur.left!=null){
                    deque.addLast(cur.left);
                }
                
                if(cur.right!=null){
                    deque.addLast(cur.right);
                }
            }else{
                TreeNode cur = deque.pollLast();
                if(cur==null){
                    ans.add(new ArrayList<>(list));
                    if(!deque.isEmpty()){
                        deque.addLast(null);
                        level++;
                        list = new ArrayList<>();
                    }
                    continue;
                }
                
                list.add(cur.val);
                
                if(cur.right!=null){
                    deque.addFirst(cur.right);
                }
                
                if(cur.left!=null){
                    deque.addFirst(cur.left);
                }
                
            }
        }
        
        return ans;
    }
    
    private List<List<Integer>> zigzagLevelOrderUsingTwoStacks(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        Stack<TreeNode> st = st1;
        int level = 0;
        st1.push(root);
        List<Integer> list = new ArrayList<>();
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            list.add(temp.val);
            if(level%2==0){
                if(temp.left!=null){
                    st2.push(temp.left);
                }
                if(temp.right!=null){
                    st2.push(temp.right);
                }
                if(st.isEmpty()){
                    st = st2;
                    ans.add(list);
                    list = new ArrayList<>();
                    level++;
                }
            }else{
                if(temp.right!=null){
                    st1.push(temp.right);
                }
                if(temp.left!=null){
                    st1.push(temp.left);
                }
                if(st.isEmpty()){
                    st = st1;
                    ans.add(list);
                    list = new ArrayList<>();
                    level++;
                }
            }
        }
        return ans;
    }
}