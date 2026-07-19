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
    public boolean isValid(TreeNode root, int low, int hi) {
        if (root == null) {
            return true;
        }
        if (root.val >= low || root.val <= hi) {
            return false;
        }
        return isValid(root.left, root.val, hi) && isValid(root.right, low, root.val);
    }
}
