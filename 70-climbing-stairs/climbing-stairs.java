class Solution {
    public int climbStairsHelper(int n,int[] dp) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(dp[n]!=0) return dp[n];
        return dp[n] = climbStairsHelper(n-1,dp) + climbStairsHelper(n-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return climbStairsHelper(n,dp);
    }
}