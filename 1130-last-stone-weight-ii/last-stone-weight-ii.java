class Solution {
    private int helper(int[] stones, int index, int sumL, int sumR, int[][]dp) {
        if(index == stones.length){
            return Math.abs(sumL - sumR);
        }
        
        if(dp[index][sumL] != -1) return dp[index][sumL];
        
        int left = helper(stones, index+1, sumL + stones[index], sumR, dp);
        int right = helper(stones, index+1, sumL, sumR + stones[index], dp);

        return dp[index][sumL] = Math.min(left , right);
    }
    public int lastStoneWeightII(int[] stones) {
        int sumStWt = 0;
        for(int stone : stones){
            sumStWt += stone;
        }
        int[][] dp = new int[stones.length][sumStWt];
        for(int[] d : dp) Arrays.fill(d,-1);
        return helper(stones, 0, 0, 0, dp);
    }
    
    
}