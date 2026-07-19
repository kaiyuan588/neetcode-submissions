class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }
    public void dfs(String s, int start, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s.substring(start, end+1))) {
                path.add(s.substring(start, end+1));
                dfs(s, end+1, path, res);
                path.remove(path.size() -1);
            }
        }
    }
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        if (s == null || s.length() == 0) return false;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
