class Solution {
    public int maxProfit(int[] arr) {
        int bestBuy = Integer.MAX_VALUE;
        int bestProfit = Integer.MIN_VALUE;

        for(int i = 0 ; i < arr.length ; i++){
            bestBuy = Math.min(arr[i],bestBuy);
            int pro = arr[i] - bestBuy ;
            bestProfit = Math.max(pro,bestProfit);
        }

        return bestProfit;
    }
}