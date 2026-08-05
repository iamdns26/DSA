class Solution {
    public void dfs(int src, boolean[] vis, List<List<Integer>> adj){
        vis[src] = true;

        for(int neigh : adj.get(src)){
            if(!vis[neigh]) dfs(neigh, vis, adj);
        }
    }
    public int makeConnected(int n, int[][] edge) {
        if(edge.length < n-1) return -1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int[] e : edge){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                dfs(i,vis,adj);
                count++;
            }
        }
        if(count == 1) return 0;
        return count-1;

    }
}