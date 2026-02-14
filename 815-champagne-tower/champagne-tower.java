class Solution {
    Double dp[][];
    public double helper(int p , int r , int c){
        if(r < 0 || c < 0 || r < c) return 0.0;
        if(r == 0 && c == 0) return p;
        if(dp[r][c] != null) return dp[r][c];
        double left = (helper(p , r-1 , c-1) - 1)/2.0;
        double right = (helper(p , r-1, c) - 1)/2.0;
        if(left < 0) left = 0.0;
        if(right < 0) right = 0.0;
        return dp[r][c] =  left + right;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        dp = new Double[101][101];
        return Math.min(1.0 , helper(poured , query_row , query_glass));
    }
    
}