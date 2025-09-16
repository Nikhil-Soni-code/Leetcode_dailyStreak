class Pair{
    int idx_1;
    int idx_2;
    public Pair(int a,int b){
        idx_1 = a;
        idx_2 = b;
    }
}
class Solution {
    private int bfs(Queue<Pair> queue,int[][] grid){
        int minutes = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair pair = queue.poll();
                int a = pair.idx_1;
                int b = pair.idx_2;

                if(a+1<grid.length&&grid[a+1][b]==1){
                    grid[a+1][b] = 2;
                    queue.add(new Pair(a+1,b));
                }
                if(b+1<grid[0].length&&grid[a][b+1]==1){
                    grid[a][b+1] = 2;
                    queue.add(new Pair(a,b+1));
                }
                if(a-1>=0&&grid[a-1][b]==1){
                    grid[a-1][b] = 2;
                    queue.add(new Pair(a-1,b));
                }
                if(b-1>=0&&grid[a][b-1]==1){
                    grid[a][b-1] = 2;
                    queue.add(new Pair(a,b-1));
                }
            }
            minutes++;
        }

        return minutes;
    }
    public int orangesRotting(int[][] grid) {   

        Queue<Pair> queue = new LinkedList();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j));
                }
            }
        }

        int time = bfs(queue,grid);
                for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return (time==-1)?0:time;
    }
}