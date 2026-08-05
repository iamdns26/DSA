class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {

        int n = nums1.length;
        Arrays.sort(nums1);

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums2[i]; // value
            arr[i][1] = i;        // original index
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] ans = new int[n];

        int left = 0;
        int right = n - 1;

        for (int num : nums1) {

            if (num > arr[left][0]) {
                ans[arr[left][1]] = num;
                left++;
            } else {
                ans[arr[right][1]] = num;
                right--;
            }
        }

        return ans;
    }
}