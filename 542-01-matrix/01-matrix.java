class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (mat[row][col] == 0) {
                    dist[row][col] = 0;
                    q.add(new int[]{row, col});
                } else {
                    dist[row][col] = Integer.MAX_VALUE;
                }
            }
        }
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

      
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];

            for (int k = 0; k < 4; k++) {
                int newRow = row + dRow[k];
                int newCol = col + dCol[k];

                
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    
                    if(dist[newRow][newCol] < dist[row][col] + 1 ) continue;
                    
                    if (dist[newRow][newCol] > dist[row][col] + 1) {
                        dist[newRow][newCol] = dist[row][col] + 1;
                        q.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return dist;
    }
}
