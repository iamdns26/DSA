class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n*n+1];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int ele = grid[i][j];
                freq[ele]++;
            }
        }
        int[] ans = {-1,-1};
        for(int i = 1 ; i < n*n+1 ; i++){
            if(freq[i]==2) ans[0] = i;
            if(freq[i]==0) ans[1] = i;
            if(ans[0] != -1 && ans[1] != -1) break;
        }
        return ans;
    }
}