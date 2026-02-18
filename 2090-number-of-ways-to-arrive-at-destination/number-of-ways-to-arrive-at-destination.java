class Solution {
    public class Pair{
        int node;
        long weight;
        Pair(int node, long weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public int dijkstra(int V, int[][] edges, int src) {
        int MOD = 1000000007;

        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            int u = e[0], v = e[1];
            long w = e[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->Long.compare(a.weight,b.weight)
        );

        long[] dist = new long[V];
        int[] count = new int[V];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[src] = 0;
        count[src] = 1;

        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            long weight = p.weight;

            if(dist[node] < weight) continue;

            for(Pair neigh : adj.get(node)){
                long newDist = weight + neigh.weight;

                if(newDist < dist[neigh.node]){
                    dist[neigh.node] = newDist;
                    pq.add(new Pair(neigh.node,newDist));
                    count[neigh.node] = count[node];
                }
                else if(newDist == dist[neigh.node]){
                    count[neigh.node] = (count[neigh.node] + count[node]) % MOD;
                }
            }
        }

        return count[V-1] % MOD;
    }

    public int countPaths(int n, int[][] roads) {
        return dijkstra(n,roads,0);
    }
}
