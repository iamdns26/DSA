class Solution {
    public void bfs(int row, int col, boolean vis[][], int[][] grid1, int[][] grid2, boolean[] flag){
        int n = grid2.length , m = grid2[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row,col});
        vis[row][col] = true;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(q.size()>0){
            int[] node = q.remove();
            int r = node[0] , c = node[1];
            for(int[] d : dir){
                int nr = r+d[0] , nc = c+d[1];
                if(nr>=0 && nc >=0 && nr<n && nc<m && grid2[nr][nc]==1 && !vis[nr][nc]){

                    if(grid1[nr][nc]==0 && grid2[nr][nc]==1) flag[0] = true;

                    q.add(new int[]{nr,nc});
                    vis[nr][nc] = true;
                }
            }
        }
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length , m = grid2[0].length;
        boolean vis[][] = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                boolean[] flag = {false};
                if(!vis[i][j] && grid1[i][j]==1 && grid2[i][j]==1){
                    bfs(i,j,vis,grid1,grid2,flag);
                    if(!flag[0]) count++;
                }
            }
        }
        return count;
    }
}