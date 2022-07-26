/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        return sb.toString();
    }
    
    private void serializeUtil(TreeNode root, StringBuilder sb) {
        if(root==null){
            sb.append("N$");
            return;
        }
        sb.append(root.val).append("$");
        serializeUtil(root.left, sb);
        serializeUtil(root.right, sb);
    }

    // Decodes your encoded data to tree.
    int idx = 0;
    public TreeNode deserialize(String data) {
        //System.out.println(data);
        String[] arr = data.split("\\$");
        return deserializeUtil(arr);
    }
    
    private TreeNode deserializeUtil(String[] arr) {
        if(arr[idx].equals("N")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(arr[idx]));
        idx++;
        root.left = deserializeUtil(arr);
        idx++;
        root.right = deserializeUtil(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));