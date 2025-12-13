class Solution {

    public int helper(String s, int idx, int[] dp) {

        if (idx == s.length()) return 1;
        if (s.charAt(idx) == '0') return 0;
        if(dp[idx] != -1) return dp[idx]; 

        int ways = 0;     

        int oneDigit = Integer.parseInt(s.substring(idx, idx + 1));
        if (oneDigit >= 1 && oneDigit <= 26) {
            ways += helper(s, idx + 1, dp);
        }
        if (idx + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(idx, idx + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += helper(s, idx + 2, dp);
            }
        }
        return dp[idx] = ways;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s, 0, dp);
    }
}
