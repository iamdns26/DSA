class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size();
        int cols = grid.get(0).size();

        int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[rows][cols];

        queue.offer(new int[] {0, 0});
        dist[0][0] = health - grid.get(0).get(0);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int currHealth = dist[row][col];

            if (row == rows - 1 && col == cols - 1) {
                return true;
            }

            for (int[] d : dir) {
                int newRow = row + d[0];
                int newCol = col + d[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {

                    int newHealth = currHealth - grid.get(newRow).get(newCol);

                    if (newHealth > 0 && newHealth > dist[newRow][newCol]) {
                        dist[newRow][newCol] = newHealth;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
        }
        return false;
    }
}