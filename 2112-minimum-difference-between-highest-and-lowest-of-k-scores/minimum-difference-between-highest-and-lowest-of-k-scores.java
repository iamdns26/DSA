class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i <= n-k ; i++){
            int ele = nums[i];
            int maxEle = nums[i+k-1]; // in part which one is the Max
            min = Math.min(min,maxEle - ele);
        }
        return min;
    }
}