class Solution {
    public class Pair{
        int idx;
        int count;
        Pair(int idx, int count){
            this.idx = idx;
            this.count = count;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
       Map<Integer,Integer> map = new HashMap<>();
       for(int i = 0 ; i < mat.length ; i++){
        int count = 0;
        for(int j = 0 ; j < mat[0].length ; j++){
            if(mat[i][j] == 1) count++;
        }
        map.put(i,count);
       } 
       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
    if(a.count == b.count)
        return Integer.compare(a.idx , b.idx);
    return Long.compare(a.count , b.count);
});
       for(int key : map.keySet()){
        pq.add(new Pair(key,map.get(key)));
       }
       int[] ans = new int[k];
        int x = 0;
       while(k-- >0){
        Pair p = pq.remove();
        ans[x++] = p.idx;
        
       }
       return ans;
    }
}