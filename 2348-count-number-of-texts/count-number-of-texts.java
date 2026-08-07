class Solution {

    int MOD = 1000000007;
    Long[] dp;

    public long solve(int idx, String s) {

        if (idx == s.length())
            return 1;

        if (dp[idx] != null)
            return dp[idx];

        long ways = 0;

        char ch = s.charAt(idx);

        int limit = (ch == '7' || ch == '9') ? 4 : 3;

        for (int len = 1; len <= limit && idx + len <= s.length(); len++) {

            boolean same = true;

            for (int j = idx; j < idx + len; j++) {
                if (s.charAt(j) != ch) {
                    same = false;
                    break;
                }
            }

            if (!same)
                break;

            ways = (ways + solve(idx + len, s)) % MOD;
        }

        return dp[idx] = ways;
    }

    public int countTexts(String pressedKeys) {

        dp = new Long[pressedKeys.length()];

        return (int) solve(0, pressedKeys);
    }
}