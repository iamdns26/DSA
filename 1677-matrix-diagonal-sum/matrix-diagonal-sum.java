class Solution {
    public int diagonalSum(int[][] mat) {
        
        int n = mat.length;
        int sum = 0;

        int row = 0 , col = 0 ;
        while(row<n) sum+=mat[row++][col++];

        row = 0 ; col = n-1 ;
        while(row<n) sum+=mat[row++][col--];

        if(n%2!=0) sum -= mat[n/2][n/2];
        return sum;
    }
}