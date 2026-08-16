class Solution {
    Map<Integer, Integer> memo;
    public int numDecodings(String s) {
        memo = new HashMap<>();
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

        int addOne = dfs(s, index+1);
        if (index+1 < s.length()) {
            int num = Integer.parseInt(s.substring(index, index+2));
            if (num >= 10 && num <= 26) {
                addOne += dfs(s, index+2);
            }
        }
        memo.put(index, addOne);
        return memo.get(index);
    }
}

