class Solution {
    public long helper(int idx, int target, int[] coin,long[][] dp){
        if(idx >= coin.length){
            if(target == 0) return 1;
            else return 0;
        }
        if(dp[idx][target] != -1) return dp[idx][target];
        long skip = helper(idx+1,target,coin,dp);
        if(target-coin[idx] < 0) return dp[idx][target] = skip;
        long take = helper(idx,target-coin[idx],coin,dp);

        return dp[idx][target] = take + skip;
    }
    public int change(int amount, int[] coins) {
        long[][] dp = new long[coins.length][amount+1];
        for(long[] d : dp) Arrays.fill(d,-1);
        return (int)helper(0,amount,coins,dp);
    }
}