import java.util.*;

class Solution {
    static class Node {
        int r, c, pr, pc;

        Node(int r, int c, int pr, int pc) {
            this.r = r;
            this.c = c;
            this.pr = pr;
            this.pc = pc;
        }
    }
    public boolean bfs(int sr, int sc, boolean[][] vis, char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(sr, sc, -1, -1));
        vis[sr][sc] = true;

        while (!q.isEmpty()) {

            Node curr = q.poll();
            for (int[] d : dir) {
                int ni = curr.r + d[0];
                int nj = curr.c + d[1];

                if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;
                if (grid[ni][nj] != grid[sr][sc]) continue;

                if (!vis[ni][nj]) {
                    vis[ni][nj] = true;
                    q.offer(new Node(ni, nj, curr.r, curr.c));
                }
                else if (ni != curr.pr || nj != curr.pc) return true;
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    if (bfs(i, j, vis, grid))return true;
                }
            }
        }
        return false;
    }
}
