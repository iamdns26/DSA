class Solution {
    public int helper(int idx, int preIdx, int[] arr, int[][] dp){
        if(idx >= arr.length) return 0;
        if(preIdx != -1 && dp[idx][preIdx] != -1) return dp[idx][preIdx];
        
        int pick = 0; 
        if(preIdx == -1 || arr[idx] > arr[preIdx]){
            pick = 1 + helper(idx+1,idx,arr,dp);
        }
        int skip = helper(idx+1,preIdx,arr,dp);
        if(preIdx != -1){
           dp[idx][preIdx] = Math.max(skip,pick);
        }
        return  Math.max(skip,pick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] d : dp) Arrays.fill(d,-1);

        return helper(0,-1,nums,dp);
    }
}