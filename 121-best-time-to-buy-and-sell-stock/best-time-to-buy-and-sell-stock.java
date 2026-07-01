class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int bestBuy = Integer.MAX_VALUE;
        for(int ele : prices){
             bestBuy = Math.min(ele,bestBuy);
            int profit = Math.abs(bestBuy - ele);
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}