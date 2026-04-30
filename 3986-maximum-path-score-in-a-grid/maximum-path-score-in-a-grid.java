class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int cost = 0; cost <= k; cost++) {
                    if (dp[i][j][cost] == -1) continue;

                    if (j + 1 < n) {
                        int val = grid[i][j + 1];
                        int addCost = (val == 0) ? 0 : 1;
                        int newCost = cost + addCost;

                        if (newCost <= k) {
                            dp[i][j + 1][newCost] = Math.max(
                                dp[i][j + 1][newCost],
                                dp[i][j][cost] + val
                            );
                        }
                    }

                    if (i + 1 < m) {
                        int val = grid[i + 1][j];
                        int addCost = (val == 0) ? 0 : 1;
                        int newCost = cost + addCost;

                        if (newCost <= k) {
                            dp[i + 1][j][newCost] = Math.max(
                                dp[i + 1][j][newCost],
                                dp[i][j][cost] + val
                            );
                        }
                    }
                }
            }
        }

        int ans = -1;
        for (int cost = 0; cost <= k; cost++) {
            ans = Math.max(ans, dp[m - 1][n - 1][cost]);
        }

        return ans;
    }
}