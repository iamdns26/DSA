class Solution {
    public boolean subsetSum(int n, int target, int[] arr, Boolean[][] dp){
        if(n==0){
            if(target==0) return true;
            else return false;
        }
        if(dp[n][target] != null) return dp[n][target];
        if(arr[n-1] <= target){
            return dp[n][target] = subsetSum(n-1,target-arr[n-1],arr,dp) || subsetSum(n-1,target,arr,dp) ;
        }
        else return dp[n][target] = subsetSum(n-1,target,arr,dp);
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums) sum+=ele;
        if(sum%2 != 0) return false;
        Boolean[][] dp = new Boolean[n+1][sum/2+1];
        return subsetSum(n,sum/2,nums,dp);
    }
}