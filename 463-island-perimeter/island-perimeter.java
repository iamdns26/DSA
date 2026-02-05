class Solution {
    public int bfs(int i, int j, boolean[][] vis, int[][] grid){
        int n = grid.length , m = grid[0].length;
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j]==0) return 1;
        
        int ans = 0;
        if(vis[i][j]) return 0;
        
        vis[i][j] = true;
        
        ans+=bfs(i+1,j,vis,grid);
        ans+=bfs(i-1,j,vis,grid);
        ans+=bfs(i,j+1,vis,grid);
        ans+=bfs(i,j-1,vis,grid);


        return ans;
    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length , m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int row = -1 , col = -1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==1){
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        return bfs(row,col,vis,grid); 
    }
}