class Solution {
    private int findMin(int[][] grid,int i,int j,int[][] dp){
        if(i==0&&j==0)return grid[i][j];
        if(i<0||j<0)return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        int up = findMin(grid,i-1,j,dp);
        int left = findMin(grid,i,j-1,dp);
        dp[i][j] = grid[i][j]+Math.min(up,left);
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return findMin(grid,grid.length-1,grid[0].length-1,dp);
    }
}