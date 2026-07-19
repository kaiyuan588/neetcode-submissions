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


/*
    Time complexity:
    1. worst case O(n^2), if each level of the tree has only one node, and there are n level, each level would be:
    cost(n) + cost(n-1) + cost(n-2) + ... + cost(1), total n levels, so the time would be 1 + 2 + ... + n => (1+n)*n/2 => n^2
    2. if the tree is balanced, each level would have total cost of (n), and there would be logn level, so the time will be n*logn

    Space complexity
    1. worst case n^2
    2. balanced case, n
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, 0, inorder.length, inorderMap);
    }

    public TreeNode build(int[] preorder, int preIndex, int inorderLeft, int inorderRight, Map<Integer, Integer> inorderMap) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int mid = inorderMap.get(preorder[preIndex]);

        int leftSizeInorder = mid - inorderLeft;
        
        root.left = build(preorder, preIndex+1, inorderLeft, mid, inorderMap);
        root.right = build(preorder, preIndex+1 + leftSizeInorder, mid+1, inorderRight, inorderMap);
        return root;
    }
}
