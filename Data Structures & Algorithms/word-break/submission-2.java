class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dic = new HashSet<>();
        for (String str: wordDict) {
            dic.add(str);
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1]; // whether the first i characters of s can be segmented
        dp[0] = true;

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dic.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
