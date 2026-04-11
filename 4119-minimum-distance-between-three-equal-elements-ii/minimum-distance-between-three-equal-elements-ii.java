class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[] last = new int[n + 1];
        int[] second = new int[n + 1];
        Arrays.fill(last, -1);
        Arrays.fill(second, -1);
        
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (second[num] != -1) {
                int dist = i - second[num];
                if (dist < minDist) {
                    minDist = dist;
                }
            }
            second[num] = last[num];
            last[num] = i;
        }

        return (minDist == Integer.MAX_VALUE) ? -1 : 2 * minDist;
    }
}