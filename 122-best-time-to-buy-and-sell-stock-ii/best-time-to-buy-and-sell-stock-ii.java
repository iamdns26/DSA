class Solution {
    int[][] dp;
    public int helper(int idx, int buy, int[] arr) {
        if(idx >= arr.length) return 0;
        if(dp[idx][buy] != -1) return  dp[idx][buy];
        int profit = 0;
        if(buy==0){
            profit = Math.max(-arr[idx] + helper(idx+1, 1, arr),0+ helper(idx+1, 0, arr));
        }
        else{
            profit = Math.max(arr[idx] + helper(idx+1, 0, arr),0+ helper(idx+1, 1, arr));
        }
        return dp[idx][buy] = profit;
    }
    public int maxProfit(int[] arr) {
        dp = new int[arr.length][2];
        for(int[] d : dp) Arrays.fill(d,-1);
        return helper(0,0,arr);
    }
}