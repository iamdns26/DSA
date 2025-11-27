class Solution {

    public int uniquePathsIIIHelper(int i, int j, int[][] grid, int total) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) return 0;
            
        if (grid[i][j] == 2) {
            if(total==0) return 1;
            return 0;
        }

        grid[i][j] = -1; 
        total--;

        int up = uniquePathsIIIHelper(i - 1, j, grid, total);
        int down = uniquePathsIIIHelper(i + 1, j, grid, total);
        int left = uniquePathsIIIHelper(i, j - 1, grid, total);
        int right = uniquePathsIIIHelper(i, j + 1, grid, total);

        grid[i][j] = 0; 

        return up + down + left + right; 
    }

    public int uniquePathsIII(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int[] start = {-1,-1};
        int total = 1; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                }
                if (grid[i][j] == 0) total++;
            }
        }
        return uniquePathsIIIHelper(start[0], start[1], grid, total);
    }
}
