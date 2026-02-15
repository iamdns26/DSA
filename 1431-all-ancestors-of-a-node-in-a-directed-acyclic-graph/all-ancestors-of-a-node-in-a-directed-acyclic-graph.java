class Solution {
    public void fill(boolean[] vis){
        for(int i = 0; i < vis.length; i++){
            vis[i] = false;
        }
    }
    public void dfs(int node, boolean[] vis,List<Integer> list,List<List<Integer>> adj){
        vis[node] = true;
        for(int neigh : adj.get(node)){
            if(!vis[neigh]){
                list.add(neigh);
                dfs(neigh,vis,list,adj);
            }
        }

    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0], v = e[1];
            adj.get(u).add(v);
        }
        boolean[] vis = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            List<Integer> list = new ArrayList<>();
            dfs(i,vis,list,adj);
            fill(vis);
            for(int j = 0 ; j < list.size() ; j++){
                ans.get(list.get(j)).add(i);
            }

        }
        return ans;
    }
}