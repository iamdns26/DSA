class Solution {
    public int lengthOfLISHelper(int idx, int prev, int[] nums, int[][] dp) {
        if(idx >= nums.length) return 0;
        if(dp[idx][prev+1] != -1) return dp[idx][prev+1];

        int pick = 0;
        if(prev == -1 || nums[idx] > nums[prev]){
            pick = 1 + lengthOfLISHelper(idx+1,idx,nums,dp);
        }
        int skip = lengthOfLISHelper(idx+1,prev,nums,dp);

        return dp[idx][prev+1] = Math.max(pick,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int [][] dp = new int[nums.length+1][nums.length+1];
        for(int[] d : dp ) Arrays.fill(d,-1);
        return lengthOfLISHelper(0,-1,nums, dp);
    }
}