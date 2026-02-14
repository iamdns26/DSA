class Solution {
    public void dfs(int[][] heights, int i, int j, boolean[][] visited, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (visited[i][j] || heights[i][j] < prevHeight) return;

        visited[i][j] = true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dirs) {
            dfs(heights, i + d[0], j + d[1], visited, heights[i][j]);
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        // DFS from Pacific border -->> top row - left column
        for (int i = 0; i < m; i++) dfs(heights, i, 0, pac, heights[i][0]);
        for (int j = 0; j < n; j++) dfs(heights, 0, j, pac, heights[0][j]);

        // DFS from Atlantic border -->> bottom row - right column
        for (int i = 0; i < m; i++) dfs(heights, i, n-1, atl, heights[i][n-1]);
        for (int j = 0; j < n; j++) dfs(heights, m-1, j, atl, heights[m-1][j]);

        // intersection of Pacific and Atlantic
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    List<Integer> l = new ArrayList<>();
                    l.add(i) ; l.add(j);
                    ans.add(l);
                }
            }
        }
        return ans;
    }  
}
