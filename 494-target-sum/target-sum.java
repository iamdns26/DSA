class Solution {
    public int helper(int idx,int[] nums, int res, int tar) {
        if(idx >= nums.length){
            if(tar==res) return 1;
            return 0;
        }
        int add = helper(idx+1,nums,res+nums[idx],tar);
        int sub = helper(idx+1,nums,res-nums[idx],tar);
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0,nums,0,target);
    }
}