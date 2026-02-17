class Solution {
    class Pair{
        int node;
        int time;
        Pair(int node,int time){
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i<=n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t : times){
            int u = t[0], v = t[1] , w = t[2];
            adj.get(u).add(new Pair(v,w));
        }
        int[] tym = new int[n+1];
        Arrays.fill(tym,Integer.MAX_VALUE);
        tym[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.time,b.time));
        pq.add(new Pair(k,0));
        while(pq.size()>0){
            Pair p = pq.remove();
            int node = p.node , time = p.time;
            if(tym[node] < time) continue;
            for(Pair neigh : adj.get(node)){
                int totalTime = time + neigh.time;
                if(totalTime < tym[neigh.node]){
                    pq.add(new Pair(neigh.node,totalTime));
                    tym[neigh.node] = totalTime;
                }
            }
        }
        int ans = -1;
        for(int i = 1 ; i <= n ; i++){
            if(tym[i]== Integer.MAX_VALUE) return -1;
            ans = Math.max(tym[i],ans);
        }
        return ans;
    }
}