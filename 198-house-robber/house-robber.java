class Solution {
    int n;
    int[] dp;
    public int helper(int idx, int[] nums) {
       if(idx >= n) return 0;
       if(dp[idx] != -1) return dp[idx];
        int take = nums[idx] + helper(idx+2,nums);
        int skip = helper(idx+1,nums);
        return dp[idx] = Math.max(take,skip);
    }
    public int rob(int[] nums) {
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(0,nums);
    }
}