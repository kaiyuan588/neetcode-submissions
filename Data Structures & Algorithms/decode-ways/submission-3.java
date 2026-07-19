class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return dfs(s, 0);
    }

    public int dfs(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        int ways = 0;

        // 1 digit
        ways += dfs(s, index+1);
        memo.put(index, ways);
        // 2 digits
        if (index+1 < s.length()) {
            int first = s.charAt(index);
            int second = s.charAt(index+1);
            if ((first - '0') * 10 + (second - '0') <= 26) {
                ways += dfs(s, index+2);
                memo.put(index, ways);
            }
        }
        return memo.get(index);
    }
}
