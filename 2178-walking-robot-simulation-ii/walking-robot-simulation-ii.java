class Robot {
    int width;
    int height;
    int x;
    int y;
    int direction;
    int[][] directions = {{0,1} , {1,0} , {0,-1} , {-1,0}};
    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        x=0;
        y=0;
        direction = 1;
    }
    
    public void step(int num) {
        int perimeter = 2*(width+height)-4;
        num = num%(perimeter);
        if(num == 0){
            num = perimeter;
            
        }
        for(int i=1 ; i<=num ; i++){
            int nx =x+ directions[direction][0];
            int ny =y+ directions[direction][1];
            if(ny==height||ny<0||nx==width || nx<0){
                i--;
                direction = (direction+3)%4;
                continue;
            }
            x = nx;
            y = ny;
        }
    }
    
    public int[] getPos() {
        return new int[]{x,y};
    }
    
    public String getDir() {
        if(direction==0)return "North";
        if(direction==1)return "East";
        if(direction==2)return "South";
        return "West";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */