class Solution {
    Map<Integer, Integer> memo;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        memo = new HashMap<>();
        int ans = dfs(coins, 0, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int dfs(int[] coins, int count, int remain) {
        if (remain == 0) {
            return 0;
        }
        if (remain < 0) {
            return -1;
        }
        if (memo.containsKey(remain)) {
            return memo.get(remain);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = dfs(coins, count+1, remain - coins[i]);
            if (res != -1) {
                min = Math.min(min, res+1);
            }
        }
        int ans = min == Integer.MAX_VALUE ? -1 : min;
        memo.put(remain, ans);
        return memo.get(remain);
    }
}
