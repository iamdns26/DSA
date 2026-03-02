class Solution {
    public int minSwaps(int[][] g) {
        int n = g.length;
        int s = 0;
        int[] z = new int[n];

        for (int i = 0; i < n; i++) {
            int j = n - 1;
            while (j >= 0 && g[i][j] == 0) j--;
            z[i] = n - j - 1;
        }

        for (int i = 0; i < n - 1; i++) {
            int need = n - i - 1;

            if (z[i] < need) {
                int k = i + 1;
                while (k < n && z[k] < need) k++;

                if (k == n) return -1;

                while (k > i) {
                    int t = z[k];
                    z[k] = z[k - 1];
                    z[k - 1] = t;
                    k--;
                    s++;
                }
            }
        }

        return s;
    }
}