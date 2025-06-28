class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0&&j==0)continue;
                int left = Integer.MAX_VALUE,top = Integer.MAX_VALUE;
                if(i>0){
                    top = dp[i-1][j];
                }
                if(j>0){
                    left = dp[i][j-1];
                }
                dp[i][j] = Math.min(left,top)+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
        
    }
}
// class Solution {

//     private int findMin(int[][] grid,int i,int j,int[][] dp){
//         if(i==0&&j==0)return grid[i][j];
//         if(i<0||j<0)return Integer.MAX_VALUE;
//         if(dp[i][j]!=-1)return dp[i][j];
//         int up = findMin(grid,i-1,j,dp);
//         int left = findMin(grid,i,j-1,dp);
//         dp[i][j] = grid[i][j]+Math.min(up,left);
//         return dp[i][j];
//     }
//     public int minPathSum(int[][] grid) {
//         int[][] dp = new int[grid.length][grid[0].length];
//         for(int[]a:dp){
//             Arrays.fill(a,-1);
//         }
//         return findMin(grid,grid.length-1,grid[0].length-1,dp);
//     }
// }