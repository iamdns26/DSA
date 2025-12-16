class Solution {
     public int robHelper(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int take = nums[idx] + robHelper(nums,idx+2,dp);
        int skip = robHelper(nums,idx+1,dp);
        return dp[idx] = Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return robHelper(nums,0,dp);
    }
}