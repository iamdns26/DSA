class Solution {
    class Pair {
        int row;
        int col;
        int dist;

        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        dist[0][0] = 1;
        pq.add(new Pair(0, 0, 1));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int r = curr.row;
            int c = curr.col;
            int d = curr.dist;

            if (r == n-1 && c == n-1) return d;

            for (int[] direction : dir) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0) {
                    if (d + 1 < dist[nr][nc]) {
                        dist[nr][nc] = d + 1;
                        pq.add(new Pair(nr, nc, d + 1));
                    }
                }
            }
        }
        return -1;
    }
}
