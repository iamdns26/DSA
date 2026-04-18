class Solution {
    public int climbStairsHelper(int n,int[] dp) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(dp[n] != -1) return dp[n];
        int one = climbStairsHelper(n-1,dp);
        int two = climbStairsHelper(n-2,dp);
        return dp[n] = one + two;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climbStairsHelper(n,dp);
    }
}