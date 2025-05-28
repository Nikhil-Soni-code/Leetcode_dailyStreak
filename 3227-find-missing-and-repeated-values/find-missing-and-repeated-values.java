class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long actualSum = 0;
        long actualSquareSum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                actualSum+=grid[i][j];
                actualSquareSum+=grid[i][j]*grid[i][j];
            }
        }
        long n = grid.length*grid.length;
        long expectedSum = n*(n+1)/2;
        long expectedSquareSum = n*(n+1)*(2*n+1)/6;
        long missingValue = (((expectedSquareSum-actualSquareSum)/(expectedSum-actualSum))+expectedSum-actualSum)/2;
        long repeatedValue = missingValue-(expectedSum-actualSum);
        return new int[]{(int)repeatedValue,(int)missingValue};

    }
}