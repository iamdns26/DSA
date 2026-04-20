class Solution {
    public int dfs(int i, int j,int par, int[][] dp, int[][] mat){

        int n = dp.length , m = dp[0].length;

        if(i<0 || j < 0 || i >= n ||  j >= m || mat[i][j] <= par) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        par = mat[i][j];

        int left = dfs(i+1,j,par,dp,mat);
        int down = dfs(i,j+1,par,dp,mat);
        int up = dfs(i-1,j,par,dp,mat);
        int right = dfs(i,j-1,par,dp,mat);

        return dp[i][j] = 1 + Math.max(Math.max(left,right), Math.max(down,up));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] d : dp) Arrays.fill(d,-1);

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(dp[i][j] == -1) dfs(i,j,Integer.MIN_VALUE,dp,matrix);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int[] d : dp){
            for(int ele : d) max = Math.max(ele,max);
        }
        return max;
    }
}