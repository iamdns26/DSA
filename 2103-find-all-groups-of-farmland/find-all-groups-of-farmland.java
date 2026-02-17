class Solution {
    public void solve(int r, int c, int[] maxCoor, int[][] land, boolean[][] vis) {
        int m = land.length;
        int n = land[0].length;
        
        vis[r][c] = true;
    
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        
        for (int i = 0; i < 4; i++) {
            int nr = dr[i] + r; 
            int nc = dc[i] + c; 
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && land[nr][nc] == 1 && !vis[nr][nc]) {
                maxCoor[0] = Math.max(maxCoor[0], nr);
                maxCoor[1] = Math.max(maxCoor[1], nc);
                
                solve(nr, nc, maxCoor, land, vis);
            }
        }
    }
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        boolean[][] vis = new boolean[m][n];
    
        List<int[]> ansList = new ArrayList<>();
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && land[i][j] == 1) {
                    int[] maxCoor = {i, j};
                    solve(i, j, maxCoor, land, vis);
                    ansList.add(new int[]{i, j, maxCoor[0], maxCoor[1]});
                }
            }
        }
        int[][] ans = new int[ansList.size()][4];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}   