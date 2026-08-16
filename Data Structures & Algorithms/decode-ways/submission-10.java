class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1]; // dp i means number of ways to decode the first i characters
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            // decoding one
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            int num = Integer.parseInt(s.substring(i-2, i));
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
