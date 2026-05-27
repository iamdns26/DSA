class Solution {
    public int robHelper(int idx, int free, int[] nums, int[][] dp) {
        if(idx >= nums.length) return 0;
        if(dp[idx][free] != -1) return dp[idx][free];
        if(free == 0) return robHelper(idx + 1, 1, nums,dp);

        int take = nums[idx] + robHelper(idx + 1, 0, nums,dp);
        int skip = robHelper(idx + 1, 1, nums,dp);

        return dp[idx][free] = Math.max(take , skip);
    }

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
       for(int[] d : dp) Arrays.fill(d,-1);
        return robHelper(0,1,nums,dp);
    }
}