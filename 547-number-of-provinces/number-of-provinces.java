class Solution {
    public void bfs(int i, int[][] adj, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;

        while(q.size() > 0){
            int row = q.remove();
            for(int j = 0 ; j < adj.length ; j++){
                if(!vis[j] && adj[row][j]==1){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }


    }
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                bfs(i,adj,vis);
                count++;
            }
        }
        return count;
    }
}