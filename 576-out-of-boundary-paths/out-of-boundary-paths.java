class Solution {
    int MOD = 1000000007;

    public int helper(int i, int j, int max, int m, int n, int move, int[][][] dp){
        if(i < 0 || j < 0 || i >= m || j >= n) return 1;
        if(move == max) return 0;

        if(dp[i][j][move] != -1) return dp[i][j][move];

        int up = helper(i+1, j, max, m, n, move+1, dp);
        int down = helper(i-1, j, max, m, n, move+1, dp);
        int left = helper(i, j+1, max, m, n, move+1, dp);
        int right = helper(i, j-1, max, m, n, move+1, dp);

        return dp[i][j][move] = ((up + down) % MOD + (left + right) % MOD) % MOD;
    }

    public int findPaths(int m, int n, int maxMove, int i, int j) {
        int[][][] dp = new int[m][n][maxMove+1];

        for(int[][] grid : dp){
            for(int[] row : grid){
                Arrays.fill(row, -1);
            }
        }

        return helper(i, j, maxMove, m, n, 0, dp);
    }
}