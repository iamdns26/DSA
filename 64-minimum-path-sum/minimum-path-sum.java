class Solution {
    public int helper(int[][] grid, int row, int col, int[][] dp) {
        int n = grid.length, m = grid[0].length;

        if (row == n - 1 && col == m - 1) return grid[row][col];
        if (row >= n || col >= m) return Integer.MAX_VALUE;

        if (dp[row][col] != -1) return dp[row][col];

        int down = helper(grid, row + 1, col, dp);
        int right = helper(grid, row, col + 1, dp);

        return dp[row][col] = grid[row][col] + Math.min(down, right);
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(grid, 0, 0, dp);
    }
}
