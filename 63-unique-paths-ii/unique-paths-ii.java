class Solution {

    private int find(int[][] grid,int i,int j,int[][] dp){
        if(i<0||j<0||grid[i][j]==1)return 0;

        if(i==0&&j==0)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        int down = find(grid,i-1,j,dp);
        int right = find(grid,i,j-1,dp);
        dp[i][j] = down+right;
        return down+right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return find(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1,dp);
        
    }
}