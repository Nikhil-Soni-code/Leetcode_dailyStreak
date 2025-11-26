class Solution {
    private int find(int[][] grid,int i,int j,int k,int sum,int[][][] dp){
        if(i==0&&j==0)return ((sum+grid[0][0])%k==0)?1:0;
        if(i<0||j<0)return 0;

        if(dp[i][j][sum]!=-1)return dp[i][j][sum];
        int left = find(grid , i , j-1 , k , (int)((long)sum+grid[i][j])%k , dp);
        int up = find(grid , i-1 , j , k , (int)((long)sum+grid[i][j])%k , dp);
        dp[i][j][sum] = (int)((long)left+up)%1000000007;
        return dp[i][j][sum];

    }
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k];
        for(int[][]a:dp){
            for(int[]b:a)Arrays.fill(b,-1);
        }
        return find(grid,grid.length-1,grid[0].length-1,k,0,dp);
    }
}