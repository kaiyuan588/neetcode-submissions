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

public class Codec {

    public StringBuilder sb = new StringBuilder();
    int index = 0;
    public String serialize(TreeNode root) {
        ser(root);
        return sb.toString();
    }

    public void ser(TreeNode root) {
        if (root == null) {
            sb.append('#');
            sb.append(',');
            return ;
        }
        sb.append(root.val);
        sb.append(',');
        ser(root.left);
        ser(root.right);
    }

    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        return deser(split);
    }
    
    public TreeNode deser(String[] split) {
        if (index == split.length-1) {
            return null;
        }
        String cur = split[index];
        index++;
        if (cur.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = deser(split);
        root.right = deser(split);
        return root;
    }
}
