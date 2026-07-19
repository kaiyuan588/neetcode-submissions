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

    StringBuilder sb = new StringBuilder();
    public int index;
    // Encodes a tree to a single string.
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

    // 1,2,#,#,3,4,#,#,5,#,#, 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        index = 0;
        return construct(split);
    } 
    public TreeNode construct(String[] split) {
        if (index == split.length-1) {
            return null;
        }
        String cur = split[index];
        index++;
        if (cur.equals("#") || cur == "") {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = construct(split);
        root.right = construct(split);
        return root;
    }
}
