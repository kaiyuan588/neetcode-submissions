class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, res, new StringBuilder());
        return res;
    }

    public void dfs(int n, int left, int right, List<String> res, StringBuilder sb) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return ;
        }
        if (left != n && left >= right) {
            sb.append('(');
            dfs(n, left+1, right, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right != n && right < left) {
            sb.append(')');
            dfs(n, left, right+1, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
