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
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean valid(TreeNode root, int leftRange, int rightRange) {
        if (root == null) {
            return true;
        }
        if (root.val <= leftRange || root.val >= rightRange) {
            return false;
        }
        boolean left = valid(root.left, leftRange, root.val);
        if (!left) {
            return false;
        }
        boolean right = valid(root.right, root.val, rightRange);
        if (!right) {
            return false;
        }
        return left && right;
    }
}
