class Solution {

    int MOD = 1000000007;
    int[][] dp;

    public int solve(int dice, int target, int k) {

        if (dice == 0) {
            return target == 0 ? 1 : 0;
        }

        if (target < 0)
            return 0;

        if (dp[dice][target] != -1)
            return dp[dice][target];

        long ways = 0;

        for (int face = 1; face <= k; face++) {
            ways += solve(dice - 1, target - face, k);
            ways %= MOD;
        }

        return dp[dice][target] = (int) ways;
    }

    public int numRollsToTarget(int n, int k, int target) {

        dp = new int[n + 1][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n, target, k);
    }
}