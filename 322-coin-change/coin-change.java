class Solution {
    public long coinChangeHelper(int idx, int amount, int[] coins,long[][] dp) {
        if(idx >= coins.length){
            if(amount==0) return 0;
            return Integer.MAX_VALUE;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        
        long skip = coinChangeHelper(idx+1,amount,coins,dp);
        if(amount - coins[idx] < 0) return dp[idx][amount] = skip;
        long take = 1 + coinChangeHelper(idx,amount-coins[idx],coins,dp);

        return  dp[idx][amount] = Math.min(take,skip);
    }
    public int coinChange(int[] coins, int amount) {
        long[][] dp = new long[coins.length+1][amount+1];
        for(long[] d : dp) Arrays.fill(d,-1);
        int ans = (int)coinChangeHelper(0,amount,coins,dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}