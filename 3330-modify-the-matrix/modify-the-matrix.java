class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == -1){
                    int max = -1;
                    for(int k=0;k<matrix.length;k++){
                        max = Math.max(max,matrix[k][j]);
                    }
                    matrix[i][j] = max;
                }
            }
        }
        return matrix;
    }
}