class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int jumps = 0;
        int currEnd = 0;
        int max = 0;

        for(int i = 0; i < n - 1; i++){

            max = Math.max(max, i + nums[i]);
            if(i == currEnd){
                jumps++;
                currEnd = max;
            }
        }

        return jumps;
    }
}