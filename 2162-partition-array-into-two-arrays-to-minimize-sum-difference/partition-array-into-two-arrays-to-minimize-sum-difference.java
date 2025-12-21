class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        int totalSum = 0;
        for (int x : nums) totalSum += x;

        int[] left = Arrays.copyOfRange(nums, 0, half);
        int[] right = Arrays.copyOfRange(nums, half, n);

        List<List<Integer>> leftSums = new ArrayList<>();
        List<List<Integer>> rightSums = new ArrayList<>();

        for (int i = 0; i <= half; i++) {
            leftSums.add(new ArrayList<>());
            rightSums.add(new ArrayList<>());
        }

        generate(left, 0, 0, 0, leftSums);
        generate(right, 0, 0, 0, rightSums);

        for (int i = 0; i <= half; i++) {
            Collections.sort(rightSums.get(i));
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= half; i++) {
            List<Integer> lList = leftSums.get(i);
            List<Integer> rList = rightSums.get(half - i);

            for (int s1 : lList) {
                int target = (totalSum / 2) - s1;
                int idx = Collections.binarySearch(rList, target);
                if (idx < 0) idx = -idx - 1;

                if (idx < rList.size()) {
                    int sum1 = s1 + rList.get(idx);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sum1));
                }
                if (idx > 0) {
                    int sum1 = s1 + rList.get(idx - 1);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sum1));
                }
            }
        }
        return ans;
    }

    void generate(int[] arr, int idx, int count, int sum, List<List<Integer>> res) {
        if (idx == arr.length) {
            res.get(count).add(sum);
            return;
        }
        generate(arr, idx + 1, count + 1, sum + arr[idx], res);
        generate(arr, idx + 1, count, sum, res);
    }
}
