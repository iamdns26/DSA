class Solution {
      int helper(int[] arr, int idx,int[] dp){
        if(idx == arr.length-1 ) return arr[idx];
        if(idx == arr.length-2 ) return arr[idx];
        if(dp[idx] != -1) return dp[idx];
        int cost = arr[idx];
        int v1 = helper(arr,idx+1,dp);
        int v2 = helper(arr,idx+2,dp);
        
        return dp[idx] = cost + Math.min(v1,v2);
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(helper(cost,0,dp),helper(cost,1,dp));
    }
}