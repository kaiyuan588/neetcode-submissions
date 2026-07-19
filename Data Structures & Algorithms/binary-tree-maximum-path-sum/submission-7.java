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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // cal res => max(res, root.val, root.val + left + right, root.val + left, root.val + right)
        int leftRightRoot = left+right+root.val;
        int rightRoot = right+root.val;
        int leftRoot = left+root.val;

        int max = Math.max(leftRightRoot, Math.max(leftRoot, rightRoot));

        res = Math.max(res, Math.max(root.val, max));
        return Math.max(Math.max(root.val, left + root.val), Math.max(root.val, right + root.val));
    }
}

    //     1
    // -2      3
