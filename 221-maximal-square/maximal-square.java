class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0||j==0){
                    if(matrix[i][j]=='0'){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = 1;
                    }
                }else{
                    if(matrix[i][j]=='1'){
                        int diagonal = dp[i-1][j-1];
                        int top = dp[i-1][j];
                        int back = dp[i][j-1];

                        dp[i][j] = Math.min(diagonal,Math.min(top,back))+1;
                    }else{
                        dp[i][j] = 0;
                    }

                }
            }
        }
        int maxArea = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                maxArea = Math.max(maxArea,dp[i][j]);
            }
        }
        return maxArea*maxArea;
    }
}