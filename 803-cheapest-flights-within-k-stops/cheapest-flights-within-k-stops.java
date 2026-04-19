class Solution {
    class Pair{
        int node;
        int cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    class Triplet{
        int node;
        int dist;
        int count;
        Triplet(int node, int dist, int count){
            this.node = node;
            this.dist = dist;
            this.count = count;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int[] e : flights){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new Pair(v,w));
        }


        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(src,0,0));

        while(q.size() > 0){
            Triplet t = q.remove();
            int node = t.node , dis = t.dist , count = t.count;

            if(count == k+1) break;
            //if(dis > dist[node]) continue;

            for(Pair neigh : adj.get(node)){

               int total = neigh.cost + dis;
               if(total < dist[neigh.node]){
                 dist[neigh.node] = total;
                 q.add(new Triplet(neigh.node,total,count+1));
               }

            }

        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];

    }
}