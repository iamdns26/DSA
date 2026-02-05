class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        long sum = 0, mxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            // add arr[j]
            sum += arr[j];
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            if (j - i + 1 == k) {
                if (map.size() == k) {
                    mxSum = Math.max(mxSum, sum);
                }
                // remove arr[i]
                map.put(arr[i], map.get(arr[i]) - 1);
                if (map.get(arr[i]) == 0) {
                    map.remove(arr[i]);
                }
                sum -= arr[i];
                i++;
            }
            j++; // ALWAYS move j
        }
        return mxSum;
    }
}
