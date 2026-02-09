class Solution {
    public boolean searchMatrix(int[][] mat, int tar) {
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(mat[i][j] == tar) return true;
            }
        }
        return false;
    }
}