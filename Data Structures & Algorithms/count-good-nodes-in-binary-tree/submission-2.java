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

    //         3
    //     3       n
    // 4.    2

class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) {
            return ;
        }
        if (max == Integer.MIN_VALUE || root.val >= max) {
            count++;
        }
        dfs(root.left, Math.max(max, root.val));
        dfs(root.right, Math.max(max, root.val));
    }
}
