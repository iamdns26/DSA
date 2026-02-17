class Solution {
    class Triplet{
        int row;
        int col;
        int effort;
        Triplet(int row, int col, int effort){
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[][] effort = new int[n][m];
        for(int[] ee : effort) Arrays.fill(ee,Integer.MAX_VALUE);
        effort[0][0] = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.effort,b.effort));
        pq.add(new Triplet(0,0,0));

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(pq.size()>0){
            Triplet t = pq.remove();
            int r = t.row, c = t.col , eff = t.effort;

            if(t.row==n-1 && t.col==m-1) return t.effort;

            if(eff > effort[r][c]) continue;
            for(int[] d : dir){
                int nr = r+d[0] , nc = c+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int e = Math.abs(arr[r][c]-arr[nr][nc]);
                    e = Math.max(e,eff);

                    if(e < effort[nr][nc]){
                        effort[nr][nc] = e;
                        pq.add(new Triplet(nr,nc,e));
                    }
                }
            }
        }
        return effort[n-1][m-1];

    }
}