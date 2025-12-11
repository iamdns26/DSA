class Solution {
    public int helper(int[][]mat,int row, int col,int[][]dp){
        // base case 
        if(row==mat.length-1) return mat[row][col];
        if(dp[row][col] != Integer.MIN_VALUE) return dp[row][col];
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        // left call
        if(col > 0){
            a = helper(mat,row+1,col-1,dp);
        }
        // middle call
        b = helper(mat,row+1,col,dp);
        // right call
        if(col < mat.length-1){
            c = helper(mat,row+1,col+1,dp);
        }    
        return dp[row][col] = mat[row][col] + Math.min(a,Math.min(b,c));
    }
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;
        int[][] dp = new int[n][n];
        for(int[] d : dp) Arrays.fill(d,Integer.MIN_VALUE);
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
           ans = Math.min(ans,helper(mat,0,i,dp));
        }
        return ans;
    }
}