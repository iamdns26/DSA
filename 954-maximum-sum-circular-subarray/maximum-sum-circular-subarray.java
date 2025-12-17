class Solution {
    public int minSubArray(int[] nums) {
        int sum = 0;
        int mnSum = Integer.MAX_VALUE; 
        for(int ele : nums){
            sum+=ele;
            mnSum = Math.min(sum,mnSum);
            if(sum>0) sum = 0;
        }
        return mnSum;
    }
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int mxSum = Integer.MIN_VALUE; 
        for(int ele : nums){
            sum+=ele;
            mxSum = Math.max(sum,mxSum);
            if(sum<0) sum = 0;
        }
        return mxSum;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        for(int ele : nums) sum+=ele;
        int maxSub = maxSubArray(nums);
        int minSub = minSubArray(nums);
        if(maxSub < 0) return maxSubArray(nums);
        return Math.max(maxSub, sum-minSub);
    }
}