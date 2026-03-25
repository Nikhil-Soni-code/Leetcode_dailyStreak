class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum = 0;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                sum += grid[i][j];
            }
        }
        long suffixSum = sum;
        long prefixSum = 0;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                prefixSum += grid[i][j];
                suffixSum -= grid[i][j];
            }
            if(prefixSum == suffixSum)return true;
        }
        prefixSum = 0;
        suffixSum = sum;
        for(int j=0 ; j<grid[0].length ; j++){
            for(int i=0 ; i<grid.length ; i++){
                prefixSum += grid[i][j];
                suffixSum -= grid[i][j];
            }
            if(prefixSum == suffixSum)return true;
        }
        return false;

       
    }
}