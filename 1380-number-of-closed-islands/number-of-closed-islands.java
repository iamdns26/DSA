class Solution {

    public void dfs(int i, int j, boolean[][] vis, int[][] grid, boolean[] flag){
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || j < 0 || i >= n || j >= m) return;
        if(grid[i][j] == 1 || vis[i][j]) return;

        if(i == 0 || j == 0 || i == n-1 || j == m-1){
            flag[0] = true;   
        }

        vis[i][j] = true;

        dfs(i+1, j, vis, grid, flag);
        dfs(i-1, j, vis, grid, flag);
        dfs(i, j+1, vis, grid, flag);
        dfs(i, j-1, vis, grid, flag);
    }

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int total = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 0){
                    boolean[] flag = new boolean[1];
                    dfs(i, j, vis, grid, flag);

                    if(!flag[0]) total++; 
                }
            }
        }
        return total;
    }
}
