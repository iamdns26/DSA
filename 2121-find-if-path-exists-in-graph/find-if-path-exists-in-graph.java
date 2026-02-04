class Solution {
    public void bfs(int s, List<List<Integer>> adj, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;

        while(q.size() > 0){
            int node = q.remove();
            for(int neig : adj.get(node)){
                if(!vis[neig]){
                    q.add(neig);
                    vis[neig] = true;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] e, int s, int d) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < e.length ; i++){
            int u = e[i][0] , v = e[i][1];
            adj.get(u).add(v) ; adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[n];
        bfs(s , adj , vis);
        return vis[d];
    }
}