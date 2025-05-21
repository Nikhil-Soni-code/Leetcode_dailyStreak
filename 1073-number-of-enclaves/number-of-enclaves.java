class Solution {
    private void dfs(int i,int j,int[][] grid){
        if(i>=grid.length||j>=grid[0].length||i<0||j<0||grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);

    }
    public int numEnclaves(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                copy[i][j] = grid[i][j];
            }
        }
        for(int i=0;i<grid.length;i++){
            if(copy[i][0]==1){
                dfs(i,0,copy);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(copy[0][i]==1){
                dfs(0,i,copy);
            }
        }
        for(int i=0;i<grid.length;i++){
            if(copy[i][copy[0].length-1]==1){
                dfs(i,copy[0].length-1,copy);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(copy[grid.length-1][i]==1){
                dfs(grid.length-1,i,copy);
            }
        }

        int count= 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(copy[i][j]==1){
                    count++;
                }
                
            }
        }
        return count;
    }
}