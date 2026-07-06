class Solution {
    public int getMaximumGenerated(int n) {
        int[] nums = new int[n+1];
        if(n==0) return 0;
        if(n==1) return 1;
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        int size = (n % 2 == 0) ? n / 2 : n / 2 + 1;

        for(int i = 1; i < size ; i++){
            int a = nums[2 * i] = nums[i];
            int b = nums[2 * i + 1] = nums[i] + nums[i + 1];
            max = Math.max(b,Math.max(a,max));
        }
        return max;
    }
}