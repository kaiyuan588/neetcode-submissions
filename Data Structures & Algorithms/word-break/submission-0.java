class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp i means 
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        Set<String> set = new HashSet<>(wordDict);

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
                if (dp[i] == true) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
