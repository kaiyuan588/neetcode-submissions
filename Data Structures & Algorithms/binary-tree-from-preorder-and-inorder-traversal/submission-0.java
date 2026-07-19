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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map<Integer, Integer> inorderMap = new HashMap<>();
        // for (int i = 0; i < inorder.length; i++) {
        //     inorderMap.put(inorder[i], i);
        // }
        return construct(preorder, inorder);
    }
    public TreeNode construct(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        // find root position in inorder
        int mid = 0;
        while (inorder[mid] != root.val) {
            mid++;
        }
        int[] preLeft = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, mid);

        int[] preRight = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] inRight = Arrays.copyOfRange(inorder, mid+1, inorder.length);

        root.left = construct(preLeft, inLeft);
        root.right = construct(preRight, inRight);
        return root;
    }

}
