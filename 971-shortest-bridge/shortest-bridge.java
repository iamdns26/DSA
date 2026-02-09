class Solution {

    public void dfs(int i, int j, Queue<int[]> q, int[][] grid, boolean[][] vis){
        int n = grid.length ; 
        int m = grid[0].length;

        if(i<0 || j<0 || i>=n || j>=m) return;
        if(grid[i][j] == 0 || vis[i][j]) return;

        q.add(new int[]{i,j});
        vis[i][j] = true;
        grid[i][j] = 2;

        dfs(i+1,j,q,grid,vis);
        dfs(i-1,j,q,grid,vis);
        dfs(i,j+1,q,grid,vis);
        dfs(i,j-1,q,grid,vis);
    }

    public int bfs(Queue<int[]> q, int[][] grid, boolean[][] vis){
        int n = grid.length ; 
        int m = grid[0].length;

        int count = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(q.size() > 0){
            int size = q.size(); 

            while(size-- > 0){
                int[] p = q.remove();
                int r = p[0] , c = p[1];
                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && !vis[nr][nc]){
                        if(grid[nr][nc] == 1) return count;
                        q.add(new int[]{nr,nc});
                        vis[nr][nc] = true; 
                    }
                }
            }
            count++;
        }
        return count;
    }

    public int shortestBridge(int[][] grid) {

        int n = grid.length ; 
        int m = grid[0].length;
        int sRow = -1 , sCol = -1;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==1){
                    sRow = i;
                    sCol = j;
                    break;
                }
            }
            if(sRow != -1) break;
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        dfs(sRow,sCol,q,grid,vis);
        return bfs(q,grid,vis);
    }
}
