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
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        // find root position in inorder
        int mid = 0;
        while (inorder[mid] != root.val) {
            mid++;
        }
        // inorder's mid can tell us how many left subtrees in the current level
        // e.g. preorder [1,2,3,4], inorder = [2,1,3,4], when root = 1 can be found in the second index of inorder, so there are 1 node in left and three nodes in right.
        // So by this information, we can find preorder [1,2,3,4], the coorsponding left subtree is from [rootIndex+1...rootIndex+1+size(1)]
        int[] preLeft = Arrays.copyOfRange(preorder, 1, mid+1); // in java exclusive on the right side
        int[] inLeft = Arrays.copyOfRange(inorder, 0, mid);

        int[] preRight = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] inRight = Arrays.copyOfRange(inorder, mid+1, inorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}
