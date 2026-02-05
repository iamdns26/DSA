class Solution {
    public void bfs(int i, int j, boolean[][] vis, char[][] grid){
        int n = grid.length , m = grid[0].length;
        if(i < 0 || j < 0 || i >= n || j >= m) return;
        if(vis[i][j]) return;
        if(grid[i][j]=='0') return;

        vis[i][j] = true;

        bfs(i+1,j,vis,grid);
        bfs(i-1,j,vis,grid);
        bfs(i,j+1,vis,grid);
        bfs(i,j-1,vis,grid);

    }
    public int numIslands(char[][] grid) {
        int n = grid.length , m = grid[0].length ;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    bfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }
}