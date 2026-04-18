class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int n = image.length , m = image[0].length;
        int pix = image[sr][sc];
        if (pix == color) return image;  // No change needed

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        while(q.size() > 0){
            int[] node = q.remove();
            int r = node[0];
            int c = node[1];
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < n && nc < m && nr >= 0 && nc >= 0 && image[nr][nc]==pix){
                    image[nr][nc] = color;
                    q.add(new int[]{nr,nc});
                }

            }
        }
        return image;
    }
}