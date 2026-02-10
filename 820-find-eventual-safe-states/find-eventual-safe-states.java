class Solution {
    public boolean dfs(int i, boolean[] vis, boolean[] par, int[][] graph){
        if(vis[i]) {
            if(par[i]) return true;
            return false;
        }
        vis[i] = true;
        par[i] = true;

        for(int neigh : graph[i]) {
            //if(par[neigh]) return true;
            if(dfs(neigh, vis, par, graph))
                return true;
        }
        par[i] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] par = new boolean[graph.length];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            if(!dfs(i, vis, par, graph)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
