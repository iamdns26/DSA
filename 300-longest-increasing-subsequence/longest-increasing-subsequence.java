class Solution {
    int[][] dp;
    public int helper(int idx, int pre , int[] arr){
        if(idx >= arr.length) return 0;
        int take = -1;
       if(dp[idx][pre+1] != -1) return dp[idx][pre+1];
        if(pre == -1 || arr[idx] > arr[pre]){
             take = 1 + helper(idx+1,idx,arr);
        }
        
        int skip =  helper(idx+1,pre,arr);
     
        return dp[idx][pre+1] = Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length+1];
        for(int [] d : dp) Arrays.fill(d,-1);
        return helper(0,-1,nums);
    }
}