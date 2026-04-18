class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;

        if(n==1) return nums[0];

        if(nums[0] < nums[n-1])
            return nums[0];

        int lo = 0, hi = n-1;
        int pivot = -1;

        while(lo <= hi){

            int mid = lo + (hi-lo)/2;

           
            if(mid < n-1 && nums[mid] > nums[mid+1]){
                pivot = mid;
                break;
            }

            
            if(nums[lo] <= nums[mid]){
                lo = mid+1;
            }

            else{
                hi = mid-1;
            }
        }

        return nums[pivot+1];
    }
}