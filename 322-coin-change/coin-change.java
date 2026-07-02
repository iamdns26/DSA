class Solution {
    long[][] dp;
    public long helper(int idx, int[] arr,int amount){
        
        if(idx>=arr.length){
            if(amount==0) return 0;
            else return Integer.MAX_VALUE;
        }

        if(dp[idx][amount] != -1) return dp[idx][amount];

        long skip = helper(idx+1,arr,amount);

        if(amount - arr[idx] < 0)return skip;

        long take = 1 + helper(idx,arr,amount-arr[idx]);

        return dp[idx][amount] = Math.min(take , skip);
    }
    public int coinChange(int[] coins, int amount) {
        dp = new long[coins.length][amount+1];
        for(long[] d : dp) Arrays.fill(d,-1);
        int ans = (int)helper(0,coins,amount);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}