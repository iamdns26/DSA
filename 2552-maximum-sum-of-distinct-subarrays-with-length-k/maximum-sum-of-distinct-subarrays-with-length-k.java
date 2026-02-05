class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        long sum = 0, mxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < n) { 
            // -->> calculation Part
            // add arr[j]
            sum += arr[j];
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            if(j - i + 1 < k) j++; // -->> adjusting the window 

            else if (j - i + 1 == k) {
                // -->> part of calculating ans
                if (map.size() == k) {
                    mxSum = Math.max(mxSum, sum);
                }
                // remove arr[i]
                map.put(arr[i], map.get(arr[i]) - 1);
                if (map.get(arr[i]) == 0) {
                    map.remove(arr[i]);
                }
                sum -= arr[i];

                // -->> sifting the window
                i++;
                j++;
            }
        }
        return mxSum;
    }
}
