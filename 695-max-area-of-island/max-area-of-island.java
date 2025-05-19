class Solution {
    int area  = 0;
    private void dfs(int[][]copy,int i,int j){
        if(i<0||j<0||i==copy.length||j==copy[0].length||copy[i][j]==0){
            return;
        }
        area++;
        copy[i][j] = 0;
        dfs(copy,i-1,j); 
        dfs(copy,i+1,j);
        dfs(copy,i,j+1);
        dfs(copy,i,j-1);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                copy[i][j] = grid[i][j];
            }
        }
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(copy[i][j]==1){
                    area = 0;

                    dfs(copy,i,j);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }
        return maxArea;

    }
}