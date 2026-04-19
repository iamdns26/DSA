class Solution {
    public boolean canFinish(int course, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < course ; i++) adj.add(new ArrayList<>());
        int[] in = new int[course];

        for(int[] e : pre){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            in[v]++;
        }

        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0 ; i < course ; i++){
            if(in[i]==0) qu.add(i);
        }
        int count = 0;
        while(qu.size() > 0){
            int par = qu.remove();
            count++;

            for(int neigh : adj.get(par)){
                in[neigh]--;
                if(in[neigh]==0) qu.add(neigh);
            }
        }
        
        return count==course;
    }
}