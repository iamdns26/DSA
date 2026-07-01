class Solution {
    int n;
    int[][] dp;
    public int helper(int idx, int flag, int[] nums) {
       if(idx >= n) return 0;
       if(dp[idx][flag] != -1) return dp[idx][flag];
       
       if(flag==1){
        int take = nums[idx] + helper(idx+1,0,nums);
        int skip = helper(idx+1,1,nums);
        return dp[idx][flag] = Math.max(take,skip);
       }
       else return dp[idx][flag] = helper(idx+1,1,nums);


    }
    public int rob(int[] nums) {
        n = nums.length;
        dp = new int[n][2];
        for(int[] d : dp) Arrays.fill(d,-1);
        return helper(0,1,nums);
    }
}