class Solution {
    private int count(int m,int n,int[][] paths,int i,int j,int[][]dp){
        if(i==m-1&&j==n-1){
            return 1;
        }
        if(i>=m||j>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int count1 = count(m,n,paths,i+1,j,dp);
        int count2 = count(m,n,paths,i,j+1,dp);
        dp[i][j] = count1+count2;
        return dp[i][j];

    }
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        int[][] dp = new int[m][n];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return count(m,n,paths,0,0,dp);
    }
}