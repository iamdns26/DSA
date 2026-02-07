class Solution {

    public int dfs(int i, int j, boolean[][] vis, int[][] grid, boolean[] flag){
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || j < 0 || i >= n || j >= m){
            return 0;
        }
        if(grid[i][j] == 0 || vis[i][j]) return 0;
        if(i == 0 || j == 0 || i == n-1 || j == m-1){
            flag[0] = true;
        }

        vis[i][j] = true;
        int count = 1;

        count += dfs(i+1, j, vis, grid, flag);
        count += dfs(i-1, j, vis, grid, flag);
        count += dfs(i, j+1, vis, grid, flag);
        count += dfs(i, j-1, vis, grid, flag);

        return count;
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int total = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    boolean[] flag = new boolean[1];
                    int size = dfs(i, j, vis, grid, flag);
                    if(!flag[0]){
                        total += size;
                    }
                }
            }
        }
        return total;
    }
}
