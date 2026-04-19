class Solution {
    boolean ans;
    public void dfs(int src, boolean[] vis, boolean[] path,List<List<Integer>> adj){
        vis[src] = true;
        path[src] = true;

        for(int neigh : adj.get(src)){
            if(path[neigh]) ans = true;

            if(!vis[neigh]){
                dfs(neigh,vis,path,adj);
            }
        }
        path[src] = false;
    }
    public boolean canFinish(int course, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < course ; i++) adj.add(new ArrayList<>());

        for(int[] e : pre){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[course];
        boolean[] path = new boolean[course];
        ans = false;
        for(int i = 0 ; i < course ; i++){
            if(ans) return false;
            dfs(i,vis,path,adj);
        }
        
        return true;
    }
}