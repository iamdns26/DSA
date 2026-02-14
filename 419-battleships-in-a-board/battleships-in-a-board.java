class Solution {
    public void dfs(int  row, int col,char[][] board){
        int n= board.length , m = board[0].length;
        if(row < 0 || col < 0 || row>=n || col>=m || board[row][col]=='.') return;
        board[row][col] = '.';
        dfs(row+1,col,board);
        dfs(row-1,col,board);
        dfs(row,col+1,board);
        dfs(row,col-1,board);
    }
    public int countBattleships(char[][] board) {
        int n= board.length , m = board[0].length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j]=='X') {
                    dfs(i,j,board);
                    count++;
                }
                
            }
        }
        return count;
    }
}