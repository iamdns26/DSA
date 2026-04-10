class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n<=2) return -1;
        int len = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                for(int k = j+1 ; k < n ; k++){
                    if(nums[i] == nums[j] && nums[j]==nums[k]){
                        int sum = Math.abs(i-j) + Math.abs(j-k) + Math.abs(k-i);
                        len = Math.min(sum,len);
                    }
                }
            }
        }
        if(len == Integer.MAX_VALUE) return -1;
        return len;
    }
}