class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0)continue;
                int left = 0;
                int up = 0;
                if(j>0){left = dp[i][j-1];}
                if(i>0){up = dp[i-1][j];}
                dp[i][j] = left+up;              
            }
        }
        return dp[m-1][n-1];
    }
}
// class Solution {
//     // tc-> n*m
//     // sc-> n*m+n+m
//     private int count(int m,int n,int[][] paths,int i,int j,int[][]dp){
//         if(i==m-1&&j==n-1){
//             return 1;
//         }
//         if(i>=m||j>=n){
//             return 0;
//         }
//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         int count1 = count(m,n,paths,i+1,j,dp);
//         int count2 = count(m,n,paths,i,j+1,dp);
//         dp[i][j] = count1+count2;
//         return dp[i][j];

//     }
//     public int uniquePaths(int m, int n) {
//         int[][] paths = new int[m][n];
//         int[][] dp = new int[m][n];
//         for(int[] a:dp){
//             Arrays.fill(a,-1);
//         }
//         return count(m,n,paths,0,0,dp);
//     }
// }