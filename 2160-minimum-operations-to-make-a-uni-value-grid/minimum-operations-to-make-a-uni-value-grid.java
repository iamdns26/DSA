class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length, m = grid[0].length;
        int size = m * n;
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = grid[i/m][i%m];
        }

        Arrays.sort(arr);

        int become = arr[size/2 ], res=0;
        for(int i = 0;i<size;i++) {
            long dis = Math.abs(arr[i] - become);
            if(dis%x!=0) return -1;
            res+= dis/x;
        }

        return res;
    }
}