class Solution {
    public int helper(int idx,int[] nums, int res, int tar, int sum, int[][] dp) {
        if(idx >= nums.length){
            if(tar==res) return 1;
            return 0;
        }
        if(dp[idx][res+sum] != -1) return dp[idx][res+sum];
        int add = helper(idx+1,nums,res+nums[idx],tar,sum,dp);
        int sub = helper(idx+1,nums,res-nums[idx],tar,sum,dp);
        return dp[idx][res+sum] = add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int ele : nums) sum+=ele;

        int[][] dp = new int[nums.length][2*sum+1];
        for(int[] d : dp) Arrays.fill(d,-1);

        return helper(0,nums,0,target, sum ,dp);
    }
}