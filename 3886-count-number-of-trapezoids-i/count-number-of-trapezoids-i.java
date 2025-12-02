class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        final int mod = 1000000007;
        long ans = 0;
        long sum = 0;
        for (int[] point : points) {
            int freq =  map.getOrDefault(point[1], 0);
            map.put(point[1],  freq  + 1);
        }
        for (int pNum : map.values()) {
            long edge = ((long) pNum * (pNum - 1)) / 2;
            ans = (ans + edge * sum) % mod;
            sum = (sum + edge) % mod;
        }
        return (int) ans;
    }
}