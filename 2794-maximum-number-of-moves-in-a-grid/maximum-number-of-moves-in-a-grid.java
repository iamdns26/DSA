class Solution {
    public int helper(int i, int j,int[][]grid,int[][] dp){

        int n = grid.length , m = grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int[][] dir = {{-1,1},{0,1},{1,1}};
        int max = 0;
        for(int[] d : dir){
            int ni = i+d[0];
            int nj = j+d[1];
            if(ni<0 || nj<0 || ni>=n || nj>=m) continue;
            if(grid[ni][nj]<=grid[i][j]) continue;

            max = Math.max(max,1+helper(ni,nj,grid,dp));
        }
        return dp[i][j] =  max;

    }
    public int maxMoves(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] d : dp) Arrays.fill(d,-1);
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max,helper(i,0,grid,dp));
        }
        return max;
    }
}