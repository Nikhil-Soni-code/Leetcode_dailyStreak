class Pair{
    int i;
    int j;
    public Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        Queue<Pair> queue = new LinkedList();
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 1)queue.add(new Pair(i,j));
            }
        }
        int distance = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k=0 ; k<size ; k++){
                Pair pair = queue.poll();
                int i = pair.i;
                int j = pair.j;

                if(i+1 < grid.length &&grid[i+1][j]==0){grid[i+1][j]=1;queue.add(new Pair(i+1,j));}
                if(j+1 < grid[0].length &&grid[i][j+1]==0){grid[i][j+1]=1;queue.add(new Pair(i,j+1));}
                if(i-1 >= 0 &&grid[i-1][j]==0){grid[i-1][j]=1;queue.add(new Pair(i-1,j));}
                if(j-1 >= 0 &&grid[i][j-1]==0){grid[i][j-1]=1;queue.add(new Pair(i,j-1));}
            }
            distance++;
        }
        if(distance==0)return -1;
        return distance;

    }
}