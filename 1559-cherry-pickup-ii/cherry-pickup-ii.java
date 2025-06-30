class Solution {
    private int findMax(int[][] grid,int i,int j1,int j2,int[][][] dp){

        if(j1<0||j1>=grid[0].length||j2<0||j2>=grid[0].length) return -1;
                if(i==grid.length-1){
            if(j1==j2)return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        int max = -1;
        for(int idx1=-1;idx1<=1;idx1++){
            for(int idx2=-1;idx2<=1;idx2++){
                if(j1==j2){
                    max = Math.max(max,grid[i][j1]+findMax(grid,i+1,idx1+j1,idx2+j2,dp));
                }
                else{
                    max = Math.max(max,grid[i][j1]+grid[i][j2]+findMax(grid,i+1,idx1+j1,idx2+j2,dp));
                }
            }
        }
        dp[i][j1][j2] = max;
        return max;

    }
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int[][]a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return findMax(grid,0,0,grid[0].length-1,dp);
    }
}