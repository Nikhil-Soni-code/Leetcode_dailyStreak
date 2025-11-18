
class Solution {
    int[][] directions = {
    {-1, 0}, // up
    {1, 0},  // down
    {0, -1}, // left
    {0, 1},  // right
    {-1, -1},// top-left
    {-1, 1}, // top-right
    {1, -1}, // bottom-left
    {1, 1}   // bottom-right
};
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1)return -1;
        if(grid.length==1&&grid[0].length==1){
            return grid[0][0]==0?1:-1;
        }
        queue.add(new int[]{0,0,1});
        while(!queue.isEmpty()){

            int size = queue.size();
            for(int k=0;k<size;k++){
                int[] node = queue.poll();
                int i=node[0];
                int j=node[1];
                int path=node[2];
                for(int[] dir : directions){
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if(ni==grid.length-1&&nj==grid[0].length-1)return path+1;
                        // Check boundaries and whether the cell is traversable
                        if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 0){
                            queue.add(new int[]{ni, nj, path + 1});
                            grid[ni][nj] = 1; // mark as visited
                        }
                    }

            }

        }
            return -1;

    }
}