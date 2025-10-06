class Solution {
    int MOD = 1000000007;
    private long count(int[][] grid,int i,int j,int prev,long[][] dp){
        if(i==grid.length||j==grid[0].length||i<0||j<0)return 0;
        if(grid[i][j]<=prev||grid[i][j]==-1)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        
        
        int temp = grid[i][j];
        grid[i][j] = -1;
        long up = count(grid,i-1,j,temp,dp);
        long down = count(grid,i+1,j,temp,dp);
        long right = count(grid,i,j+1,temp,dp);
        long left = count(grid,i,j-1,temp,dp);
        grid[i][j] = temp;
        dp[i][j] = (1+up+down+right+left)%MOD;
        return dp[i][j];



    }
    public int countPaths(int[][] grid) {
        long[][] dp = new long[grid.length][grid[0].length];
        for(long[]a:dp){
            Arrays.fill(a,-1);
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                count(grid,i,j,0,dp);
            }
        }
        long ans = 0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                ans=(ans+dp[i][j])%MOD;
            }
        }
        return (int)ans;
    }
}