class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
        List<List<Integer>> hel = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            List<Integer> a = new ArrayList<>();
            hel.add(a);
        }
        for(int j = 0 ; j < n ; j++){
            for(int i = 0 ; i < n ; i++){
                hel.get(j).add(mat[i][j]);
            }
        }
        for(int i = 0 ; i <n ; i++){
            Collections.reverse(hel.get(i));
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                mat[i][j] = hel.get(i).get(j);
            }
        }
    }
}