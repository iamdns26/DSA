class Robot {
    int dir[][] = {
        {1, 0},{0, 1},{-1, 0},{0, -1}
    };
    int wx = 0, hy = 0, idx = 0;
    int locx = 0, locy = 0;
    int p = 0;
    public Robot(int width, int height) {
        wx = width-1; hy = height-1;
        p = 2 * (wx + hy);
    }
    
    public void step(int num) {
        num %= p;
        if (num == 0) num = p;
        while(num-- >0) {
            if(
                (locx == 0 && dir[idx][0] == -1)
                || (locx == wx && dir[idx][0] == 1)
                || (locy == hy && dir[idx][1] == 1)
                || (locy == 0 && dir[idx][1] == -1)
            ) 
                idx = (idx + 1) % 4;
            
            locx = locx + dir[idx][0];
            locy = locy + dir[idx][1];
        }
    }
    
    public int[] getPos() {
        return new int[]{locx, locy};
    }
    
    public String getDir() {
        if(idx == 0) return "East";
        if(idx == 1) return "North";
        if(idx == 2) return "West";
        return "South";
    }
}