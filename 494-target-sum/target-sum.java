class Solution {
    public int ways(int idx , int[] nums, int res , int target , int[][] dp , int sum) {
        if(idx==nums.length){
            if(res==target) return 1;
            return 0;
        }
        if(dp[idx][res+sum] != -1) return dp[idx][res+sum];
        int add = ways(idx+1 , nums , res+nums[idx] , target , dp , sum);
        int sub = ways(idx+1 , nums , res-nums[idx] , target , dp , sum);
        return dp[idx][res+sum] = add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int ele : nums) sum+=ele ;
        int[][] dp = new int[nums.length][1+2*sum];
        for(int[] row : dp) Arrays.fill(row,-1);
        return ways(0,nums,0,target,dp,sum);
    }
}