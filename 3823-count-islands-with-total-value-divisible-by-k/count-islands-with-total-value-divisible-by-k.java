class Solution {
    public long dfs(int i, int j, boolean[][] vis, int[][] grid){
        int n = grid.length , m = grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m) return 0;
        if(vis[i][j] || grid[i][j]<=0) return 0;
        vis[i][j] = true;
        long sum = 0;
        sum += grid[i][j];
        long down = dfs(i+1,j,vis,grid);
        long up = dfs(i-1,j,vis,grid);
        long right = dfs(i,j+1,vis,grid);
        long left = dfs(i,j-1,vis,grid);

        return sum + left + right + up + down;
    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length , m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] > 0){
                    if(dfs(i,j,vis,grid)%k==0) count++;
                    
                }
            }
        }
        return count;
    }
}