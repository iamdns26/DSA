class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int maxSum = nums[0], curMax = 0;
        int minSum = nums[0], curMin = 0;

        for (int num : nums) {
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);
        }

        return Math.max(maxSum,Math.abs(minSum));
       
    }
}