class Solution {
    public long helper(int idx , int[]coins , int amount ,long [][] dp){
        if(idx<0){
            if(amount==0) return 0;
            return Integer.MAX_VALUE;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        long skip = helper(idx-1,coins,amount,dp);
        if(amount - coins[idx] < 0) return dp[idx][amount] = skip;
        long pick = 1 + helper(idx,coins,amount-coins[idx],dp);
        return dp[idx][amount] = Math.min(skip,pick);
    }
    public int coinChange(int[] coins, int amount) {
        long [][] dp = new long[coins.length][amount+1]; 
        for(long[] row : dp) Arrays.fill(row,-1);   

        int ans =  (int)helper(coins.length-1,coins,amount,dp);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}