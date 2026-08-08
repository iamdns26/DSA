class Solution {

    int[] dp;
    public boolean isPalindrome(String s, int i, int j) {

        while (i < j) {

            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
    public int solve(int idx, String s) {

        if (idx == s.length())
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int ans = Integer.MAX_VALUE;

        for (int j = idx; j < s.length(); j++) {

            if (isPalindrome(s, idx, j)) {

                int remaining = 1 + solve(j + 1, s);

                ans = Math.min(ans,remaining);
            }
        }

        return dp[idx] = ans;
    }


    public int minCut(String s) {

        int n = s.length();
        dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0, s) - 1;
    }

    
    
}