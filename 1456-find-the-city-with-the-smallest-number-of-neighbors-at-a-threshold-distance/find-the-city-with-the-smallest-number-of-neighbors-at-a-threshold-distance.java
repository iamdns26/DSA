class Solution {
    public int findTheCity(int n, int[][] edges, int thres) {
        int[][] dist = new int[n][n];
        for(int[] arr : dist) Arrays.fill(arr,Integer.MAX_VALUE);
        for(int[] arr : edges){
            int u = arr[0], v = arr[1], w = arr[2] ;
            dist[u][v] = w;
            dist[v][u] = w;
        }
        
        // Floyd Warshall
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                if(i==k) continue;
                for(int j = 0 ; j < n; j++){
                    if(i==j || j==k) continue;
                    if(dist[i][k] < Integer.MAX_VALUE && dist[k][j] < Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int minCity = -1;
        int minCount = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int count = 0;
            for(int j = 0 ; j < n; j++){
                if(i==j) continue;
                if(dist[i][j] <= thres) count++;
            }
            if(count <= minCount) {
                minCount = count;
                minCity = i;
            }
        }
        return minCity;
    }
}