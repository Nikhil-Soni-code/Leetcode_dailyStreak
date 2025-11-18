class Solution {
    private int dfs(int i,int j,int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0 || grid[i][j] == -1)return 0;
        int temp = grid[i][j];
        grid[i][j] = -1;
        int left = dfs(i,j-1,grid);
        int right = dfs(i,j+1,grid);
        int top = dfs(i-1,j,grid);
        int bottom = dfs(i+1,j,grid);
        grid[i][j] = temp;
        return temp+Math.max(left,Math.max(right,Math.max(top,bottom)));

    }
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    maxGold = Math.max(maxGold,dfs(i,j,grid));
                }
            }
        }
        return maxGold;
    }
}