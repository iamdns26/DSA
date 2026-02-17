class Solution {

    public int[] bfs(int i, boolean[] vis, List<List<Integer>> adj){
        Queue<Integer> q = new ArrayDeque<>();
        int[] ans = {0,0};
        int node = 0;
        int count = 0;

        q.add(i);
        vis[i] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            node++;
            count += adj.get(curr).size();
            for(int neigh : adj.get(curr)){
                if(!vis[neigh]){
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
        }

        ans[0] = node;
        ans[1] = count;   
        return ans;
    }

    public int countCompleteComponents(int n, int[][] edges) {
       
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] ee : edges){
            int u = ee[0] , v = ee[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int count = 0;
        boolean[] vis = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                int[] edge = bfs(i,vis,adj);

                int nodes = edge[0];
                int edgesCount = edge[1] / 2;  // divide because undirected

                if(edgesCount == (nodes*(nodes-1))/2) count++;
            }
        }
        return count;
    }
}
