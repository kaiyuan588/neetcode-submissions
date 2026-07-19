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
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[1];
        tmp[0] = k;
        inOrder(root, tmp);
        return ans;
    }
    public void inOrder(TreeNode root, int[] k) {
        if (root == null) {
            return ;
        }
        inOrder(root.left, k);
        k[0]--;
        if (k[0] == 0) {
            ans = root.val;
        }
        inOrder(root.right, k);
    }
}
