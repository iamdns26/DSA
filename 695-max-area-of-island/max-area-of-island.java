class Solution {
    public int dfs(int i, int j, boolean[][] vis, int[][] grid){
        int n = grid.length , m = grid[0].length;
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j]==0 || vis[i][j]) return 0;

        vis[i][j] = true;
        int area = 1;

        area += dfs(i+1,j,vis,grid);
        area += dfs(i-1,j,vis,grid);
        area += dfs(i,j+1,vis,grid);
        area += dfs(i,j-1,vis,grid);

        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    max = Math.max(max,dfs(i,j,vis,grid));
                }
            }
        }
        return max;
    }
}