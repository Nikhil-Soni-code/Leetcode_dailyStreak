class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0||j==0){
                    dp[i][j] = matrix[i][j];
                }
                else{
                    if(matrix[i][j]==0){
                        dp[i][j] = 0;
                    }else{
                        int top = dp[i-1][j];
                        int diagonal = dp[i-1][j-1];
                        int left = dp[i][j-1];
                        dp[i][j] = Math.min(top,Math.min(diagonal,left))+1;
                    }
                }
            }
        }
        int sum = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                sum+=dp[i][j];
            }
        }return sum;
    }
}