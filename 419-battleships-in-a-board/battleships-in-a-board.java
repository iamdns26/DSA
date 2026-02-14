class Solution {
    public void dfs(int  row, int col, boolean[][] vis ,char[][] board){
        int n = board.length , m = board[0].length;

        if(row < 0 || col < 0 || row>=n || col>=m ) return;
        if(vis[row][col] || board[row][col] == '.') return;

        vis[row][col] = true;

        dfs(row+1,col,vis,board);
        dfs(row-1,col,vis,board);
        dfs(row,col+1,vis,board);
        dfs(row,col-1,vis,board);
    }
    public int countBattleships(char[][] board) {
        int n= board.length , m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && board[i][j]=='X') {
                    dfs(i,j,vis,board);
                    count++;
                }
                
            }
        }
        return count;
    }
}