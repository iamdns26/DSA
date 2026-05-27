class Solution {
    public int helper(int i, int n, int[] dp){
        if(i==n) return 1;
        if(i > n) return 0;
        if(dp[i] != -1) return dp[i];
        int a = helper(i+1,n,dp);
        int b = helper(i+2,n,dp);
        return dp[i] = a + b;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(0,n,dp);
    }
}