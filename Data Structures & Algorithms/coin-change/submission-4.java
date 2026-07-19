class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int res = dfs(coins, 0, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int dfs(int[] coins, int cur, int amount) {
        if (memo.containsKey(cur)) {
            return memo.get(cur);
        }

        if (cur == amount) {
            return 0;
        }

        if (cur > amount) {
            return Integer.MAX_VALUE;
        }

        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (cur > amount - coin) continue;
            int min = dfs(coins, cur + coin, amount);
            if (min != Integer.MAX_VALUE) {
                res = Math.min(res, min + 1);
            }
        }

        memo.put(cur, res);
        return res;
    }
}