class Solution {
    class Pair {
        int v;
        int w;
        Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public void dfs(int node, List<List<Pair>> adj, boolean[] vis, int[] ans) {
        vis[node] = true;

        for (Pair neigh : adj.get(node)) {
            ans[0] = Math.min(ans[0], neigh.w);

            if (!vis[neigh.v]) {
                dfs(neigh.v, adj, vis, ans);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] e : roads) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        boolean[] vis = new boolean[n + 1];
        int[] ans = {Integer.MAX_VALUE};

        dfs(1, adj, vis, ans);
        return ans[0];
    }
}