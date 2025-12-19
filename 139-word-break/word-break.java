class Solution {
    public boolean dfs(int idx, String s, Set<String> set, Boolean[] dp) {
        if (idx == s.length()) return true;

        if (dp[idx] != null) return dp[idx];

        for (int end = idx + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(idx, end)) &&
                dfs(end, s, set, dp)) {
                return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return dfs(0, s, set, dp);
    }
}
