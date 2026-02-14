import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Arrays.asList(0);

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] degree = new int[n];
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
         // traverse from the leaf node
        for(int i = 0; i < n; i++) {
            if(degree[i] == 1) {
                q.offer(i);
            }
        }

        int rem = n;

        while(rem > 2) {
            int size = q.size();
            rem -= size;

            for(int i = 0; i < size; i++) {
                int node = q.poll();

                for(int neigh : adj.get(node)) {
                    degree[neigh]--;
                    if(degree[neigh] == 1) {
                        q.offer(neigh);
                    }
                }
            }
        }

        return new ArrayList<>(q);
    }
}
