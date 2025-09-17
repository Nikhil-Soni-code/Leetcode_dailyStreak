class Solution {
    private void dfs(int[][] grid,int i,int j){
        if(i<0||j<0||i==grid.length||j==grid[0].length||grid[i][j]==0)return;
        grid[i][j] = 0;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);



    }
    public int numEnclaves(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==1){
                dfs(grid,i,0);
            }
        }
        for(int i=0;i<grid.length;i++){
            if(grid[i][grid[0].length-1]==1){
                dfs(grid,i,grid[0].length-1);
            }
        }
        for(int j=0;j<grid[0].length;j++){
            if(grid[0][j]==1){
                dfs(grid,0,j);
            }
        }
        for(int j=0;j<grid[0].length;j++){
            if(grid[grid.length-1][j]==1){
                dfs(grid,grid.length-1,j);
            }
        }
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)count++;
            }
        }return count;
    }
}