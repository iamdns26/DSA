class Solution {
    public int Leader(int a, int[] par){
        if(par[a]==a) return a;
        return par[a] = Leader(par[a],par);
    }
    public void Union(int a, int b, int[] size, int[] par){
        a = Leader(a,par); // leaderA
        b = Leader(b,par); // // leaderB
        if(a != b){   // if leader same then dont do anything

            if(size[a] > size[b]){
                par[b] = a;
                size[a] += size[b];
            }
            else{
                par[a] = b;
                size[b] += size[a];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1]; // node start from the 1
        int[] size = new int[n+1];

        for(int i = 1 ; i <= n ; i++){
            par[i] = i;
            size[i] = 1;
        }

        int[] ans = new int[2];
        for(int[] e : edges){
            int u = e[0] , v = e[1];
            if(Leader(u,par)==Leader(v,par)){
                ans[0] = u ; ans[1] = v;
                return ans;
            }
            else Union(u,v,size,par);
        }
       for(int ele:size)  System.out.print(ele +" ");
        return ans;
    }
}