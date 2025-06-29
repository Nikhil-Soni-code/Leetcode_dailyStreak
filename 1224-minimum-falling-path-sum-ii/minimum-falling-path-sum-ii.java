class Solution {
    int MOD = 1000000007;
    private int findMin(int[][] grid,int i,int j,int[][] dp){
        if(i==grid.length-1){
            return grid[i][j];
        }
        if(dp[i][j]!=MOD)return dp[i][j];
        int min = MOD;

        for(int idx=0;idx<grid[0].length;idx++){
            if(idx==j)continue;
            min = Math.min(min,findMin(grid,i+1,idx,dp));
        }
        dp[i][j] = min+grid[i][j];
        return dp[i][j];
    }
    public int minFallingPathSum(int[][] grid) {
        int min = MOD;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] a:dp){
            Arrays.fill(a,MOD);
        }
        for(int i=0;i<grid[0].length;i++){
            min = Math.min(min,findMin(grid,0,i,dp));
        }
        return min;
    }
}