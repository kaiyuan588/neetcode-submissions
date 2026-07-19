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
        return isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    public boolean isValid(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val >= min || root.val <= max) {
            return false;
        }
        return isValid(root.left, root.val, max) && isValid(root.right, min, root.val);
    }
}
