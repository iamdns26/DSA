class Solution {
    int n;
    int[] dp;
    public int helper(int i, int[] cost) {
        if(i==n) return 0;
        if(i > n) {
            return Integer.MAX_VALUE - cost[i-2];
        }
        if(dp[i] != -1) return dp[i];
        int v1 = cost[i] + helper(i+1, cost);
        int v2 = cost[i] + helper(i+2, cost);
        // int v2 =  Integer.MAX_VALUE;
        // if(i <= n-2) v2 = cost[i] + helper(i+2, cost);
        return dp[i] = Math.min(v1,v2);
    }

    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        
        int v1 = helper(0,cost);
        int v2 = helper(1,cost);
        return Math.min(v1,v2);
    }
}