class Solution {
    public boolean dfs(int src, boolean[] vis, boolean[] path,List<List<Integer>> adj){
        vis[src] = true;
        path[src] = true;

        for(int neigh : adj.get(src)){
            if(path[neigh]) return true;

            if(!vis[neigh]){
                if(dfs(neigh,vis,path,adj)) return true;
            }
        }
        path[src] = false;

        return false;
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
        for(int i = 0 ; i < course ; i++){
            
            if(dfs(i,vis,path,adj)) return false;
        }
        
        return true;
    }
}