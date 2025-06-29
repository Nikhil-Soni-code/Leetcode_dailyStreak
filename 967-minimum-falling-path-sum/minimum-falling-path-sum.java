class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[] dp = new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            dp[i] = matrix[0][i];
        }
        for(int i=1;i<matrix.length;i++){
            int prev = 1000000007;
            for(int j=0;j<matrix[0].length;j++){
                int curr = dp[j];
                int next = 1000000007;
                if(j<matrix[0].length-1) next = dp[j+1];
                dp[j] = Math.min(prev,Math.min(curr,next))+matrix[i][j];
                prev = curr;
            }
        }
        int min = 1000000007;
        for(int i=0;i<dp.length;i++){
            min = Math.min(dp[i],min);
        }
        return min;
    }
}
// class Solution {
//     int MOD = 1000000007;
//     private int minSum(int i,int j,int[][] matrix,int[][] dp){
//         if(j<0||j>=matrix[0].length)return MOD;
//         if(i==matrix.length-1)return matrix[i][j];
//         if(dp[i][j]!=MOD)return dp[i][j];
//         int x = minSum(i+1,j,matrix,dp);
//         int y = minSum(i+1,j-1,matrix,dp);
//         int z = minSum(i+1,j+1,matrix,dp);
//         dp[i][j] = matrix[i][j]+Math.min(x,Math.min(y,z));
//         return dp[i][j];

//     }
//     public int minFallingPathSum(int[][] matrix) {
//         int min = MOD;
//         int[][] dp = new int[matrix.length][matrix[0].length];
//         for(int[] a:dp){
//             Arrays.fill(a,MOD);
//         }
//         for(int i=0;i<matrix[0].length;i++){
//             min = Integer.min(min,minSum(0,i,matrix,dp));
//         }
//         return min;
//     }
// }