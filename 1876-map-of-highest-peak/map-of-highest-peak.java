class Pair{
    int i;
    int j;
    int dist;
    public Pair(int i,int j,int dist){
        this.i = i;
        this.j = j;
        this.dist = dist;

    }
}
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][] height = new int[isWater.length][isWater[0].length];
        for(int[]a:height){
            Arrays.fill(a,-1);
        }
        Queue<Pair> queue = new LinkedList();
        for(int i=0;i<isWater.length;i++){
            for(int j=0;j<isWater[0].length;j++){
                if(isWater[i][j]==1){
                    queue.add(new Pair(i,j,0));
                    height[i][j] = 0;
                }
            }
        }
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int i = pair.i;
            int j = pair.j;
            int dist = pair.dist;

            if(i+1<isWater.length&&height[i+1][j]==-1){
                queue.add(new Pair(i+1,j,dist+1));
                height[i+1][j] = dist+1;
            }
            if(j+1<isWater[0].length&&height[i][j+1]==-1){
                queue.add(new Pair(i,j+1,dist+1));
                height[i][j+1] = dist+1;
            }
            if(i-1>=0&&height[i-1][j]==-1){
                queue.add(new Pair(i-1,j,dist+1));
                height[i-1][j] = dist+1;
            }
            if(j-1>=0&&height[i][j-1]==-1){
                queue.add(new Pair(i,j-1,dist+1));
                height[i][j-1] = dist+1;
            }

        }
        return height;
    }
}