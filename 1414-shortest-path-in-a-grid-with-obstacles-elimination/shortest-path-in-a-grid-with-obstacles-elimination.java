class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(vis[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, k, 0}); // r, c, rem k, steps
        vis[0][0] = k;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            int rem = curr[2], steps = curr[3];

            if(r == n-1 && c == m-1) return steps;

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int newK = rem - grid[nr][nc];

                    if(newK >= 0 && vis[nr][nc] < newK){
                        vis[nr][nc] = newK;
                        q.add(new int[]{nr, nc, newK, steps+1});
                    }
                }
            }
        }

        return -1;
    }
}