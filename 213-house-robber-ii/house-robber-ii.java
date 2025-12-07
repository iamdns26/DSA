class Solution {
     int helper(int[] arr, int idx,int[] dp, int endIdx){
        if (idx >= endIdx) return 0;
        if(dp[idx] != -1) return dp[idx];
         
        int v1 = arr[idx] + helper(arr,idx+2,dp, endIdx); // take 
        int v2 = helper(arr,idx+1,dp, endIdx); // skip
        return dp[idx] = Math.max(v1,v2);
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];

        Arrays.fill(dp,-1);
        int v1 = helper(nums,0,dp,nums.length-1);

        Arrays.fill(dp,-1);
        int v2 = helper(nums,1,dp,nums.length);
        
        return Math.max(v1,v2);
    }
}