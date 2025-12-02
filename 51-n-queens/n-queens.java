class Solution {
    public static boolean isSafe(char[][] board, int row, int col){
        int n = board.length;
        // // check row --> East & West
        // for (int j = 0; j < n; j++) {
        //     if(board[row][j]=='Q') return false;
        // }
        // check col --> North & South
        for (int i = 0; i < n; i++) {
            if(board[i][col]=='Q') return false;
        }
        // check North-East
        int i = row , j = col ;
        while(i>=0 && j<n){
            if(board[i][j]=='Q') return false;
            i-- ; j++;
        }
        // check South-East
        i = row ; j = col ;
        while(i<n && j<n){
            if(board[i][j]=='Q') return false;
            i++ ; j++;
        }
        // check South-West
        i = row ; j = col ;
        while(i<n && j>=0){
            if(board[i][j]=='Q') return false;
            i++ ; j--;
        }
        // check North-West
        i = row ; j = col ;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q') return false;
            i-- ; j--;
        }
        return true;
    }
    public static void nQueen(char[][] board, int row, List<List<String>> ans){
        int n = board.length;
        if(row==n){
            // copy the 2D char Array into String list
            List<String> l = new ArrayList<>();
            for(int i=0 ; i<n ; i++){
                String s = "";
                for(int j=0 ; j<n ; j++){
                    s+=board[i][j];
                }
                l.add(s);
            }
            ans.add(l);
            return;
        }
        for (int j = 0; j < n; j++) {
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueen(board,row+1,ans);
                board[row][j] = '.'; // backtracking
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                board[i][j] = '.';
            }
        }
        nQueen(board,0,ans);
        return ans;
    }
}