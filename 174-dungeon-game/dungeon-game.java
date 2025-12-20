class Solution {
    public int helper(int row, int col, int[][] arr, int[][] dp){
        int m = arr.length , n = arr[0].length;
        if(row >= m || col >= n) return Integer.MAX_VALUE;
        if(row==m-1 && col == n-1){
            if(arr[row][col] < 0){
               return 1 - arr[row][col];
            }
            else return 1;
        }
        if(dp[row][col] != -1) return dp[row][col];

        int down = helper(row+1,col,arr,dp);
        int right = helper(row,col+1,arr,dp);

        int ans = Math.min(down,right) - arr[row][col];
        if(ans > 0) return dp[row][col] = ans;
        else return dp[row][col] = 1;
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for(int[] d : dp)Arrays.fill(d,-1);
        return helper(0,0,dungeon,dp);
    }
}