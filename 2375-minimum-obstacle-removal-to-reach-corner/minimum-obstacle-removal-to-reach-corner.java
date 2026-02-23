class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new LinkedList<>();
        dq.addFirst(new int[]{0, 0});
        dist[0][0] = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1];

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                int cost = grid[nr][nc];
                int newCost = dist[r][c] + cost;

                if(newCost < dist[nr][nc]){
                    dist[nr][nc] = newCost;
                    if(cost == 0){
                        dq.addFirst(new int[]{nr, nc}); // priority
                    } else {
                        dq.addLast(new int[]{nr, nc});
                    }
                }
            }
        }

        return dist[n-1][m-1];
    }
}