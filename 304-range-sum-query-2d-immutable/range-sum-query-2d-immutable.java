class NumMatrix {
    int[][] arr;
    int[][] pre;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        this.arr = matrix;
        pre = new int[n+1][m+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                pre[i][j] = arr[i-1][j-1] + pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        if(row1 == 0 && col1 == 0) return pre[row2+1][col2+1];
        return pre[row2+1][col2+1] - pre[row2+1][col1] - pre[row1][col2+1] + pre[row1][col1];

    }
}
