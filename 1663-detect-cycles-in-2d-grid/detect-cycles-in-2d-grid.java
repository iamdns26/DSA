class Solution {

    public boolean dfs(int i, int j, int pi, int pj,boolean[][] vis, char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        vis[i][j] = true;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;
            if (grid[ni][nj] != grid[i][j]) continue;

            // If not visited → continue DFS
            if (!vis[ni][nj]) {
                if (dfs(ni, nj, i, j, vis, grid))
                    return true;
            }
            // If visited AND not parent → cycle
            else if (ni != pi) {
                return true;
            }
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    if (dfs(i, j, -1, -1, vis, grid))return true;
                }
            }
        }

        return false;
    }
}
