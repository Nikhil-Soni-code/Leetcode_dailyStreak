class Solution {
    private int visit(int[][] grid , int i, int j, int count, int targetCount){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == -1)return 0;
        if(grid[i][j] == 2){
                System.out.println(count);

            if(count == targetCount){
                return 1;
            }
            return 0;
        }
        grid[i][j] = -1;
        int left = visit(grid,i,j-1,count+1,targetCount);
        int right = visit(grid,i,j+1,count+1,targetCount);
        int top = visit(grid,i-1,j,count+1,targetCount);
        int bottom = visit(grid,i+1,j,count+1,targetCount);
        grid[i][j] = 0;
        return left + right + top + bottom;

    }
    public int uniquePathsIII(int[][] grid) {
        int emptyCells = 0;
        int start_i = -1 , start_j = -1;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]==0)emptyCells++;
                else if(grid[i][j]==1){
                    start_i = i;
                    start_j = j;
                }
            }
        }

        return visit(grid,start_i,start_j,0,emptyCells+1);
    }
}