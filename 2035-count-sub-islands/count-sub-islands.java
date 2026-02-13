class Solution {
    public void dfs(int row, int col, boolean vis[][], int[][] grid1, int[][] grid2, boolean[] flag){
        int n = grid2.length , m = grid2[0].length;
        if(row<0 || col < 0 || row>=n || col>=m) return;
        if(grid2[row][col]==0 || vis[row][col]) return;

        if(grid2[row][col]==1 && grid1[row][col]==0){
            flag[0] = true;
        }

        vis[row][col] = true;
       
        dfs(row+1,col,vis,grid1,grid2,flag);
        dfs(row-1,col,vis,grid1,grid2,flag);
        dfs(row,col+1,vis,grid1,grid2,flag);
        dfs(row,col-1,vis,grid1,grid2,flag);

    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length , m = grid2[0].length;
        boolean vis[][] = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                boolean[] flag = {false};
                if(!vis[i][j] && grid1[i][j]==1 && grid2[i][j]==1){
                    dfs(i,j,vis,grid1,grid2,flag);
                    if(!flag[0]) count++;
                }
            }
        }
        return count;
    }
}