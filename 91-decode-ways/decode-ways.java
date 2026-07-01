class Solution {
    int[] dp;
    public int helper(int idx, String s) {

        if (idx == s.length()) return 1;
        if (s.charAt(idx) == '0') return 0;
        if(dp[idx] != -1) return dp[idx];

        int ways = helper(idx + 1, s);

        if (idx + 1 < s.length()) {
            int two = Integer.parseInt(s.substring(idx, idx + 2));

            if (two >= 10 && two <= 26) {
                ways += helper(idx + 2, s);
            }
        }

        return dp[idx] = ways;
    }

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(0, s);
    }
}