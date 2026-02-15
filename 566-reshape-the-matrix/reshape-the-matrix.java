class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length , m = mat[0].length;
        if(n * m != r * c)  return mat;
        int[] temp = new int[n*m];
        int x = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                temp[x++] = mat[i][j];
            }
        }
        x = 0;
        int[][] ans = new int[r][c];
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                ans[i][j] = temp[x++];
            }
        }
        return ans;
    }
}