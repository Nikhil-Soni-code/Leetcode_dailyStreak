class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int []a:dp){
            Arrays.fill(a,0);
        }

        dp[0][0] = (obstacleGrid[0][0]==1)?0:1;
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[0].length;j++){
                if(i==0&&j==0)continue;
                if(obstacleGrid[i][j]==1)continue;
                int up = 0,left = 0;
                
                if(i>0){
                    up = dp[i-1][j];
                }
                if(j>0){
                    left = dp[i][j-1];
                }
                dp[i][j] = up+left;
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
// class Solution {

//     private int find(int[][] grid,int i,int j,int[][] dp){
//         if(i<0||j<0||grid[i][j]==1)return 0;

//         if(i==0&&j==0)return 1;
//         if(dp[i][j]!=-1)return dp[i][j];
//         int down = find(grid,i-1,j,dp);
//         int right = find(grid,i,j-1,dp);
//         dp[i][j] = down+right;
//         return down+right;
//     }
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
//         for(int[]a:dp){
//             Arrays.fill(a,-1);
//         }
//         return find(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1,dp);
        
//     }
// }