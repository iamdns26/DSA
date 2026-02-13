class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        list.add(0);
        dfs(0,graph,ans,list);

        return ans;

    }

    public void dfs(int node,int graph[][], List<List<Integer>>ans, List<Integer>list){
        if(node==graph.length-1){
            ans.add(new ArrayList<>(list));
        }

        for(int neigh : graph[node]){
            list.add(neigh);
            dfs(neigh,graph,ans,list);
            list.remove(list.size()-1);
        }
    }
}