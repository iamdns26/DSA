class Solution {
     int helper(int[] arr, int idx,int[] dp){
        if (idx >= arr.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        
        int v1 = arr[idx] + helper(arr,idx+2,dp);
        int v2 = helper(arr,idx+1,dp);
        
        return dp[idx] = Math.max(v1,v2);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
}