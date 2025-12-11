class Solution {
    private int dfs(List<List<Integer>> triangle, int row, int col, int[][] dp){
        if(row == triangle.size() - 1){
            return triangle.get(row).get(col);
        }
        
        if(dp[row][col] != Integer.MIN_VALUE){
            return dp[row][col];
        }
        int left = dfs(triangle, row + 1, col, dp);
        int right = dfs(triangle, row + 1, col + 1, dp);
    
        dp[row][col] = triangle.get(row).get(col) + Math.min(left, right);
        return dp[row][col];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return dfs(triangle, 0, 0, dp);
    }   
}