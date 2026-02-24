class Solution {
    public int find(int a, int[] par){
        if(par[a] == a) return a;
        return par[a] = find(par[a], par);
    }
    public void union(int a, int b, int[] par, int[] size) {
        a = find(a, par);
        b = find(b, par);

        if(a!=b){
            if(size[a]>size[b]){
                par[b] = a;
                size[a]+=size[b];
            }
            else{
                par[a] = b;
                size[b]+=size[a];
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        int[] par = new int[n];
        int[] size = new int[n];

        for(int i = 0; i < n; i++){
            par[i] = i;
            size[i] = 1;
        }

        Map<String,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 1 ; j < accounts.get(i).size() ; j++){
                String key = accounts.get(i).get(j);

                if(!map.containsKey(key)){
                    map.put(key, i);
                }
                else union(i, map.get(key), par, size);
            }
        }

        Map<Integer, List<String>> hel = new HashMap<>();

        for(String email : map.keySet()){

            int parent = find(map.get(email), par);

            if(!hel.containsKey(parent)){
                hel.put(parent, new ArrayList<>());
            }
            hel.get(parent).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int parent : hel.keySet()){

            List<String> list = hel.get(parent);
            Collections.sort(list);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(parent).get(0)); // name
            temp.addAll(list);
            ans.add(temp);
             
        }
        return ans;
    }
}