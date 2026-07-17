class Solution {
    Boolean[][] dp;
    public boolean helper(int idx, int res, int tar,int[] arr){
        if(idx==arr.length){
            if(res==tar) return true;
            else return false;
        }
        if(dp[idx][res] != null) return dp[idx][res];
        if(arr[idx] + res <= tar){
            boolean take = helper(idx+1, res+arr[idx] , tar, arr);
            boolean skip = helper(idx+1, res , tar, arr);

            return dp[idx][res] = take || skip;
        }
        return dp[idx][res] = helper(idx+1, res , tar, arr);
    }
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int ele : nums) sum += ele;

        if(sum%2 != 0) return false;
        dp = new Boolean[nums.length][sum/2 +1];

        return helper(0,0,sum/2,nums);

    }
}