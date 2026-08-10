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
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, new int[]{0}, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int[] preorderIndex, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex[0]]);
        preorderIndex[0]++;

        root.left = build(preorder, preorderIndex, left, inorderMap.get(root.val)-1);
        root.right = build(preorder, preorderIndex, inorderMap.get(root.val)+1, right);
        return root;
    }
}

// preorder 1 is the root
// find the root from inorder 


