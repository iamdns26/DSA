class Solution {
    public int dfs(int i, int j, int[][] grid,int[][] dir){
        int n = grid.length , m = grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0) return 0;
        int sum = grid[i][j];
        grid[i][j] = 0;

        for(int[] d : dir){
            int nr = i+d[0] , nc = j+d[1];
            sum += dfs(nr,nc,grid,dir);
        }
        return sum;
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int ans = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}} ;
        for(int i = 0 ; i < n ; i++){
            for(int j= 0 ; j < m ; j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans,dfs(i,j,grid,dir));
                }
            }
        }
        return ans;
    }
}