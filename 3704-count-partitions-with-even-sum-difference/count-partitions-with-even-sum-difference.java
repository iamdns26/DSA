class Solution {
    public int helper(int idx, int s1, int sum, int[] nums){
        if(idx==nums.length-1) return 0;
        int count = 0;
        int s2 = sum-s1;
        if((s1-s2)%2==0) count+=1;
        int a = helper(idx+1, s1+nums[idx], sum, nums);
        return count+=a;
    }
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int ele : nums) sum+=ele;
        return helper(0,0,sum,nums);
    }
}