class Solution {
    public void bfs(int i, int j, char[][] grid){
        int n = grid.length , m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        grid[i][j] = '0';

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(q.size()>0){
            int[] node = q.remove();
            int r = node[0];
            int c = node[1];

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == '1'){
                    q.add(new int[]{nr,nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length , m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]=='1'){
                    bfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
}