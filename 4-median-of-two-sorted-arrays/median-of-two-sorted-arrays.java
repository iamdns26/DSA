class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length , n = nums2.length;
        int[] arr = new int[m+n];
        int i = 0, j = 0, k = 0;

        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                arr[k++] = nums1[i++];
            }
            else{
                arr[k++] = nums2[j++];
            }
        }
        while(i < m) arr[k++] = nums1[i++];
        while(j < n) arr[k++] = nums2[j++];
        int x = m+n;
        if((m+n) % 2 != 0) return arr[x/2];

        return (arr[x/2] + arr[x/2-1]) / 2.0;
    }
}