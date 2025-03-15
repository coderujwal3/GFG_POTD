class Solution {
    public int minCoins(int coins[], int sum) {
        // code here
        int dp[] = new int[sum + 1];
        int n = coins.length;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
            }
        }
        return dp[sum] == Integer.MAX_VALUE ? -1 :  dp[sum];
    }
}
