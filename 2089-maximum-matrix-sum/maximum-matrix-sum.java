class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long negCount = 0;
        long sum = 0;
        int minNegative = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0)negCount++;
                sum+=Math.abs(matrix[i][j]);
                minNegative = Math.min(minNegative,Math.abs(matrix[i][j]));
            }
        }
        if(negCount%2==0)return sum;
        else return sum - (2*minNegative);
    }
}