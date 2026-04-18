class Solution {
    public int helper(int n, int[] cost, int[] dp){
        if(n<0) return 0;
        if(dp[n] != -1) return dp[n];
        int v1 = helper(n-1,cost,dp);
        int v2 = helper(n-2,cost,dp);
        return dp[n] = cost[n] + Math.min(v1,v2);

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(helper(n-1,cost,dp),helper(n-2,cost,dp));
    }
}