class Solution {
    public void did(int[][] arr, int i, int j) {
        int n = arr.length, m = arr[0].length;

        int r = i, c = j;

        // up
        while (r >= 0) {
            arr[r--][j] = 0;
        }

        // down
        r = i;
        while (r < n) {
            arr[r++][j] = 0;
        }

        // right
        while (c < m) {
            arr[i][c++] = 0;
        }

        // left
        c = j;
        while (c >= 0) {
            arr[i][c--] = 0;
        }
    }
    public void setZeroes(int[][] mat) {
        List<int[]> hel = new ArrayList<>();
        int n = mat.length , m = mat[0].length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j]==0){
                    hel.add(new int[]{i,j});
                }
            }
        }

        for(int i = 0 ; i < hel.size() ; i++){
           int[] a = hel.get(i);
           int r = a[0];
           int c = a[1];
           did(mat,r,c);
        } 
    }
}