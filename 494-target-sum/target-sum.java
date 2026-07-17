class Solution {
    public int helper(int idx,int res, int tar, int[] nums){
        if(idx==nums.length){
            if(res==tar) return 1;
            return 0;
        }
        int add = helper(idx+1, res + nums[idx] , tar, nums);
        int sub = helper(idx+1, res - nums[idx] , tar, nums);

        return add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int ele : nums) sum+=ele;

        return helper(0, 0 ,target, nums);
    }
}