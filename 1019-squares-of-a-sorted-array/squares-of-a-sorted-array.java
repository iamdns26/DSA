class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int i = 0 , j = n-1 , k = n-1;

        while(i<=j){
            int val1 = nums[i];
            int val2 = nums[j];

            if(val1 < 0) val1 = -1*val1;
            if(val2 < 0) val2 = -1*val2;

            if(val1 < val2){
                ans[k--] = val2*val2;
                j--;
            }
            else{
                ans[k--] = val1*val1;
                i++;
            }
        }
        return ans;
    }
}