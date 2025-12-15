class Solution {
    public int helper(int target, int[] nums, Integer[] dp) {
        if (target == 0) return 1;
        if (target < 0) return 0;

        if (dp[target] != null) return dp[target];

        int count = 0;
        for (int num : nums) {
            count += helper(target - num, nums, dp);
        }

        return dp[target] = count;
    }

    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        return helper(target, nums, dp);
    }
}
