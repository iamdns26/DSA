class Solution {
    int[][] dp;
    public int helper(int idx,int res, int tar, int[] nums, int sum){
        if(idx==nums.length){
            if(res==tar) return 1;
            return 0;
        }
        if(dp[idx][sum+res] != -1) return dp[idx][sum+res];
        int add = helper(idx+1, res + nums[idx] , tar, nums,sum);
        int sub = helper(idx+1, res - nums[idx] , tar, nums,sum);

        return dp[idx][sum+res] = add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int ele : nums) sum+=ele;
        dp = new int[nums.length][2*sum+1];
        for(int[] d : dp) Arrays.fill(d,-1);
        return helper(0, 0 ,target, nums, sum);
    }
}