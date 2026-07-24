class Solution {
    private int dfs(int i, int j, int m, int n, String word1, String word2, int[][] dp) {
        if (i == 0) return j;
        if (j == 0) return i;
        if (dp[i][j] != 0) return dp[i][j];

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) return dp[i][j] = dfs(i - 1, j - 1, m, n, word1, word2, dp);
        else return dp[i][j] = Math.min( 1 + dfs(i - 1, j, m, n, word1, word2, dp), 1 + dfs(i, j - 1, m, n, word1, word2, dp));
        
         
    }

    public int minDistance(String word1, String word2) {
        // Top-down
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        return dfs(m, n, m, n, word1, word2, dp);

    }
}