class Solution {
    public int bfs(int row, int col, char[][] maze){
        int n = maze.length, m = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        q.add(new int[]{row, col});
        maze[row][col] = '+';

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];

                if((r == 0 || c == 0 || r == n-1 || c == m-1) && !(r == row && c == col)){
                    return steps;
                }

                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr < 0 || nc < 0 || nr >= n || nc >= m || maze[nr][nc] == '+') continue;

                    maze[nr][nc] = '+';
                    q.add(new int[]{nr, nc});
                }
            }
            steps++;
        }
        return -1;
    }

    public int nearestExit(char[][] maze, int[] start) {
        return bfs(start[0], start[1], maze);
    }
}