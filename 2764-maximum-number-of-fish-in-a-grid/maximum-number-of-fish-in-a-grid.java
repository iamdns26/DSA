class Solution {
    public int dfs(int i, int j, int[][] grid){
        int n = grid.length , m = grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0) return 0;
        int sum = grid[i][j];
        grid[i][j] = 0;
        sum += dfs(i+1,j,grid);
        sum += dfs(i-1,j,grid);
        sum += dfs(i,j+1,grid);
        sum += dfs(i,j-1,grid);
        return sum;
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j= 0 ; j < m ; j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans,dfs(i,j,grid));
                }
            }
        }
        return ans;
    }
}