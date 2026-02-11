class Solution {
    public int minSubArrayLen(int tar, int[] arr) {
        int len = Integer.MAX_VALUE;
        int i = 0 , j = 0 , n = arr.length;
        int sum = 0;
        while(j<n){
            sum += arr[j];
            while(sum>=tar){
                len = Math.min(len,j-i+1);
                sum-=arr[i++];
            }
            j++;
        }

        if(len==Integer.MAX_VALUE) return 0;
        return len;
    }
}