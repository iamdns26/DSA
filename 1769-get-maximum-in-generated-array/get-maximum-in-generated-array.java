class Solution {
    public int getMaximumGenerated(int n) {
        if(n < 1) return 0;
        if(n < 3) return 1;

        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;

        int iter = n - 1; // we are fetching the 2 * i -- > that's why
        int max = 0;
        for(int i = 1; i <= iter/2; i++){
    
            nums[2*i] = nums[i]; 
            nums[2*i+1] = nums[i]+nums[i+1];  

            if(nums[i] > max) max = nums[i];
            if(nums[2*i+1] > max) max = nums[2*i+1];
        }
        return max;
    }
}