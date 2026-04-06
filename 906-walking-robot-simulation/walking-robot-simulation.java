class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set = new HashSet();
        for(int[] o: obstacles){
            set.add(o[0]+","+o[1]);
        }
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int x = 0,y=0;
        int direction = 0;
        int ans = 0;
        for(int i=0 ; i<commands.length ; i++){
            if(commands[i]==-1){
                direction = (direction+1)%4;
            }else if(commands[i]==-2){
                direction = (direction+3)%4;
            }
            else{
                for(int j=1 ; j<=commands[i] ; j++){
                    int nx = x+directions[direction][0];
                    int ny = y+directions[direction][1];

                    if(set.contains(nx+","+ny)){
                        break;
                    }
                    x = nx;
                    y = ny;
                    ans = Math.max(ans,x*x + y*y);
                }
            }
        }
        return ans;
    }
}