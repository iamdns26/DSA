class Solution {

    public boolean check(int r, int c, int[][] mat){

        if(mat[r][c] != 1) return false;

        int row = 0;
        int col = 0;

        for(int j = 0 ; j < mat[0].length ; j++){
            if(mat[r][j] == 1) row++;
        }

        for(int i = 0 ; i < mat.length ; i++){
            if(mat[i][c] == 1) col++;
        }

        return row == 1 && col == 1;
    }

    public int numSpecial(int[][] mat) {

        int count = 0;

        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(check(i,j,mat)) count++;
            }
        }

        return count;
    }
}