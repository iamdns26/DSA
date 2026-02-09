class Solution {
    public void dfs(int i, int j,boolean[][] vis, char[][]board){
        int n = board.length , m = board[0].length ;
        if(i<0 || j<0 || i>=n || j>=m) return;
        if(board[i][j] == 'X' || vis[i][j]) return;
        board[i][j] = '*';
        vis[i][j] = true;
        dfs(i+1,j,vis,board);
        dfs(i-1,j,vis,board);
        dfs(i,j+1,vis,board);
        dfs(i,j-1,vis,board);
    }

    public void solve(char[][] board) {
        int n = board.length , m = board[0].length ;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n; i++){
            if(board[i][0]=='O') dfs(i,0,vis,board);
        }
        for(int i = 0 ; i < n; i++){
            if(board[i][m-1]=='O') dfs(i,m-1,vis,board);
        }
        for(int j = 1 ; j < m-1; j++){
            if(board[0][j]=='O') dfs(0,j,vis,board);
        }
        for(int j = 1 ; j < m-1; j++){
            if(board[n-1][j]=='O') dfs(n-1,j,vis,board);
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j]=='*') board[i][j] = 'O';
                else if(board[i][j]=='O') board[i][j] = 'X';
            }
        }
    }
}