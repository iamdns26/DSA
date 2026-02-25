class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int zero = 0, one = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                    one++;
                }
                else zero++;
            }
        }
        if(one==0 || zero==0) return -1;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int count = 0;
        
        while(q.size()>0){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int[] a = q.remove();
                int r = a[0], c = a[1];

                for(int[] d : dir){
                    int nr = r + d[0], nc = c + d[1];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= m || grid[nr][nc]==1) continue;

                    grid[nr][nc] = 1;
                    q.add(new int[]{nr,nc});
                }
            } 
            count++;
        }
        return count-1;
    }
}