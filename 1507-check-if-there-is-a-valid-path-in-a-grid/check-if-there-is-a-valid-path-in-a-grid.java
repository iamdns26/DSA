class Solution {

    public static int[][] ST = { { 0, 0 }, { 1, 3 }, { 0, 2 }, { 3, 2 }, { 1, 2 }, { 0, 3 }, { 0, 1 } };
    public static int[][] DIR = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];

        if (grid[0][0] == 5) {
            return false;
        }

        if (grid[0][0] == 4) {
            visit[0][0] = true;
            if (isValid(grid, visit, 0, 1, n, m, 3)) {
                return true;
            }
            visit = new boolean[n][m];
            visit[0][0] = true;
            return isValid(grid, visit, 1, 0, n, m, 0);
        }

        int par = (grid[0][0] == 2 || grid[0][0] == 6) ? 0 : 3;
        return isValid(grid, visit, 0, 0, n, m, par);
    }

    public boolean isValid(int[][] grid, boolean[][] visit, int x, int y,
                           int n, int m, int par) {

        while (!((x == n - 1) && (y == m - 1))) {
            visit[x][y] = true;

            int[] d = ST[grid[x][y]];
            if (d[0] != par && d[1] != par) {
                return false;
            }

            int newDir = d[0] + d[1] - par;
            x = x + DIR[newDir][0];
            y = y + DIR[newDir][1];

            if (x < 0 || y < 0 || x >= n || y >= m || visit[x][y]) {
                return false;
            }

            par = (2 + newDir) % 4;
        }

        int[] d = ST[grid[x][y]];
        return (d[0] == par || d[1] == par);
    }
}