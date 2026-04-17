class Solution {
    public int minDistanceHelper(int i, int j, String s1, String s2, int[][] dp) {
        if(i < 0) return j+1; // word1 = "" and word2 = "abc"
        if(j < 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = minDistanceHelper(i-1, j-1, s1, s2, dp);
        else{
            int del = minDistanceHelper(i-1, j, s1, s2, dp);
            int ins = minDistanceHelper(i, j-1, s1, s2, dp);
            int rep = minDistanceHelper(i-1, j-1, s1, s2, dp);

            return dp[i][j] = 1 + Math.min(del, Math.min(ins,rep));
        }

    }
    public int minDistance(String word1, String word2) {
        int n = word1.length() , m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] d : dp) Arrays.fill(d,-1);
        return minDistanceHelper(n-1,m-1,word1,word2,dp);
    }
}