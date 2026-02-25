class Solution {
    public void dfs(int node,boolean[] vis,List<List<Integer>> adj,Set<String> set,int[] count){
        vis[node] = true;
        for(int neigh : adj.get(node)){
            if(!vis[neigh]){
                if(set.contains(node + "$" + neigh)) count[0]++; 
                dfs(neigh,vis,adj,set,count);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
       List<List<Integer>> adj = new ArrayList<>();
       for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
       Set<String> set = new HashSet<>();

       for(int[] e : connections){
        int u = e[0], v = e[1];
        adj.get(u).add(v);
        adj.get(v).add(u);
        set.add(u+"$"+v);
       }
       boolean[] vis = new boolean[n];
       int[] ans = {0};
       dfs(0,vis,adj,set,ans) ;
       return ans[0];
    }
}