class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        // push all rotten oranges in queue
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        if(fresh == 0) return 0;
        
        int min = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
        // BFS
        while(!q.isEmpty()){
            int size = q.size();
            boolean spread = false;
            
            for(int s = 0; s < size; s++){
                int[] curr = q.remove();
                int r = curr[0];
                int c = curr[1];
                
                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    
                    if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr,nc});
                        fresh--;
                        spread = true;
                    }
                }
            }
            if(spread) min++;
        }
        
        return fresh == 0 ? min : -1;
    }
}
