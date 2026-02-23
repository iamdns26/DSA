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
        int cost;
        int count;
        Triplet(int node, int cost, int count){
            this.node = node;
            this.cost = cost;
            this.count = count;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < flights.length ; i++){
            int u = flights[i][0], v = flights[i][1], cost = flights[i][2];
            adj.get(u).add(new Pair(v,cost));
        }
        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src] = 0;
        Queue<Triplet> pq = new LinkedList<>();
        pq.add(new Triplet(src,0,0));

        while(pq.size() > 0){
            Triplet t = pq.remove();
            int node = t.node , cost = t.cost , count = t.count;
            if(count==k+1) break;
            for(Pair p : adj.get(node)){
                int newCost = p.cost + cost;
                if(newCost < ans[p.node]){
                    ans[p.node] = newCost;
                    pq.add(new Triplet(p.node,newCost,count+1));
                }
            }
        }
        if(ans[dst] == Integer.MAX_VALUE) return -1;
        return ans[dst];
    }
} 