class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int jump = 0;

        while(right < n-1){
            int maxJump = 0;
            for(int i = left ; i <= right ; i++){
                maxJump = Math.max(maxJump, i+nums[i]);
            }
            left = right+1;
            right = maxJump;
            jump++;
        }
        return jump++;
    }
}