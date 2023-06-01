class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[++amount];
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i < amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i - c < 0) break;
                if (dp[i - c] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], 1 + dp[i - c]);
            }
        }
        return dp[--amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}