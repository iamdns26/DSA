class Solution {
    public boolean dfs(int i, boolean[] vis, boolean[] path, int[][] graph){
        vis[i] = true;
        path[i] = true;

        for(int neigh : graph[i]) {
            if(path[neigh]) return true;
            if(!vis[neigh]){
                if(dfs(neigh, vis, path, graph)) return true;
            }
        }
        path[i] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] path = new boolean[graph.length];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            if(!dfs(i, vis, path, graph)) {
                ans.add(i);
            }
        }
        return ans;
    }
}