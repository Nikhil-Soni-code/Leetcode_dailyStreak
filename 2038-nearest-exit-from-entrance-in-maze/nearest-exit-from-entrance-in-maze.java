class Pair{
    int i;
    int j;
    int time;
    public Pair(int i,int j,int time){
        this.i = i;
        this.j = j;
        this.time = time;

    }
}
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair> queue = new LinkedList();
        queue.add(new Pair(entrance[0],entrance[1],0));

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int idx=0 ; idx<size ; idx++){
                Pair pair = queue.poll();
                int i = pair.i,j = pair.j;
                if((i == 0 || j == 0 || i == maze.length-1 || j == maze[0].length-1) && (i != entrance[0] || j != entrance[1])){
                    return pair.time;
                }
                if(i > 0 && maze[i-1][j] == '.'){
                    queue.add(new Pair(i-1,j,pair.time+1));
                    maze[i-1][j] = '+';
                }
                if(j > 0 && maze[i][j-1] == '.'){
                    queue.add(new Pair(i,j-1,pair.time+1));
                    maze[i][j-1] = '+';
                }                
                if(i < maze.length-1 && maze[i+1][j] == '.'){
                    queue.add(new Pair(i+1,j,pair.time+1));
                    maze[i+1][j] = '+';
                }                
                if(j < maze[0].length-1 && maze[i][j+1] == '.'){
                    queue.add(new Pair(i,j+1,pair.time+1));
                    maze[i][j+1] = '+';
                }
            }
        }
        return -1;
    }
}