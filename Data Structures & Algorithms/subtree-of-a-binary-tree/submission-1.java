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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        serialize(root, a);
        serialize(subRoot, b);
        return kmpContains(a, b);
    }

    // Preorder serialize with null markers
    private void serialize(TreeNode node, List<String> out) {
        if (node == null) {
            out.add("#");          // null marker
            return;
        }
        out.add("V" + node.val);   // prefix avoids ambiguity
        serialize(node.left, out);
        serialize(node.right, out);
    }

    // KMP on list of tokens
    private boolean kmpContains(List<String> text, List<String> pattern) {
        if (pattern.isEmpty()) return true;
        int[] lps = buildLps(pattern);

        int i = 0; // text index
        int j = 0; // pattern index
        while (i < text.size()) {
            if (text.get(i).equals(pattern.get(j))) {
                i++;
                j++;
                if (j == pattern.size()) return true;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    private int[] buildLps(List<String> pat) {
        int m = pat.size();
        int[] lps = new int[m];
        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pat.get(i).equals(pat.get(len))) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}