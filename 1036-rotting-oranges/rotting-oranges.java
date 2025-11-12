class Pair{
    int i;
    int j;
    public Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        boolean freshExist = false;
        Queue<Pair> queue = new LinkedList();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j));
                }
                if(grid[i][j]==1){
                    freshExist = true;
                }
            }
        }
        if(queue.isEmpty()){
            if(!freshExist)return 0;
            return -1;
            }
        int time = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair pair = queue.poll();
                int row = pair.i;
                int col = pair.j;
                if(row>0&&grid[row-1][col]==1){
                    grid[row-1][col] = 2;
                    queue.add(new Pair(row-1,col));
                }
                if(row<grid.length-1&&grid[row+1][col]==1){
                    grid[row+1][col] = 2;
                    queue.add(new Pair(row+1,col));
                }
                if(col>0&&grid[row][col-1]==1){
                    grid[row][col-1] = 2;
                    queue.add(new Pair(row,col-1));
                }
                if(col<grid[0].length-1 && grid[row][col+1]==1){
                    grid[row][col+1] = 2;
                    queue.add(new Pair(row,col+1));
                }
            }
            time++;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
        

    }
}