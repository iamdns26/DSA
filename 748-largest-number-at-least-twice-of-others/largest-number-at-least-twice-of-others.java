class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int idx = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > max){
                max = nums[i];
                idx = i;
            }
        }
        Arrays.sort(nums);
        boolean flag = nums[nums.length-2] * 2 <= nums[nums.length-1];
        if(flag) return idx;
        return -1;
    }
}