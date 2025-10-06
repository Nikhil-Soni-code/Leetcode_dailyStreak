class Solution {
    private int find(int[][] matrix, int i, int j, int prev, int[][] memo){
        if(i==matrix.length || j==matrix[0].length || i<0 || j<0) return 0;
        if(matrix[i][j] <= prev) return 0;
        
        // If already computed for this cell with current prev < matrix[i][j]
        if(memo[i][j] != -1) return memo[i][j];
        int up = 0,down = 0,left = 0,right = 0;
        up = find(matrix, i-1, j, matrix[i][j], memo);
        down = find(matrix, i+1, j, matrix[i][j], memo);
        left = find(matrix, i, j-1, matrix[i][j], memo);
        right = find(matrix, i, j+1, matrix[i][j], memo);

        memo[i][j] = 1 + Math.max(up, Math.max(down, Math.max(left, right)));
        return memo[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int[]a:memo){
            Arrays.fill(a,-1);
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                max = Math.max(max, find(matrix, i, j, -1, memo));
            }
        }
        return max;
    }
}
