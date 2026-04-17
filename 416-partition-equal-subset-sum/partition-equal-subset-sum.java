class Solution {
     public boolean canPartitionHelper(int idx, int res, int tar,int[] nums, Boolean[][] dp) {
        if(idx >= nums.length){
            if(res==tar) return true;
            return false;
        }
        if(dp[idx][res] != null) return dp[idx][res];
        boolean skip = canPartitionHelper(idx+1,res,tar,nums, dp);
        if(res + nums[idx] > tar) return dp[idx][res] =  skip;

        boolean take = canPartitionHelper(idx+1,res+nums[idx],tar,nums, dp);
        return dp[idx][res] =  skip || take;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums) sum+=ele;
        if(sum % 2 != 0) return false;
        Boolean[][] dp = new Boolean[nums.length+1][sum/2+1];
        return canPartitionHelper(0,0,sum/2,nums,dp);
    }
}