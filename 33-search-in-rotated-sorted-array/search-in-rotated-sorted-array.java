class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int lo = 0;
        int hi = n-1;
        while(lo<=hi){ // right sorted part
            int mid = lo + (hi-lo)/2;
            if(arr[mid]==target) return mid;
            if(arr[mid] <= arr[hi]){
                if(target <= arr[hi] && target > arr[mid]) lo = mid+1;
                else hi = mid-1;
            }
            else{ // left sorted part
                if(target >= arr[lo] && target < arr[mid]) hi = mid-1;
                else lo = mid+1;

            }
        }
        return -1;
    }
}