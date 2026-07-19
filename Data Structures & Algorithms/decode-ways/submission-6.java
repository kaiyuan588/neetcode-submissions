class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] = dp[i] + dp[i-1];
            } 
            int calRes = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
            if (calRes <= 26 && calRes >= 10) {
                dp[i] = dp[i] + dp[i-2];
            }
        }
        return dp[dp.length-1];
    }
}
