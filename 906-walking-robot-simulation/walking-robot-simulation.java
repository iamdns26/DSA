class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        // Directions: up, right, down, left
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int d = 0; // start facing up

        int x = 0, y = 0;
        int maxDist = 0;

        // store obstacles
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + "_" + obs[1]);
        }

        for (int cmd : commands) {
            // if (cmd == -1) {
            //     d = (d + 1) % 4; // turn right
            //     continue;
            // } else if (cmd == -2) {
            //     d = (d + 3) % 4; // turn left
            //     continue;
            // }
            
            if(cmd < 0) {
                cmd = cmd == -1 ? 1 : 3;
                d = (d + cmd) % 4;
                continue;
            }

            // move step by step
            for (int i = 0; i < cmd; i++) {
                int nx = x + dirs[d][0];
                int ny = y + dirs[d][1];

                if (set.contains(nx + "_" + ny)) break;

                x = nx;
                y = ny;

                maxDist = Math.max(maxDist, x*x + y*y);
            }
        }

        return maxDist;
    }
}