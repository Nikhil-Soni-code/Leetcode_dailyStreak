class Solution {
    private int findMax(int[][] grid,int i,int j,int k,int cost,int[][][] dp){
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0)return -10000;
        if(i==grid.length-1 && j==grid[0].length-1){
            if(grid[i][j]==1 || grid[i][j]==2)cost += 1;
            if(cost>k)return -10000;
            return grid[i][j];
        }
        cost += grid[i][j]==0?0:1;
        if(cost>k)return -10000;
        if(dp[i][j][cost]!=-1)return dp[i][j][cost];


        int right = findMax(grid,i,j+1,k,cost,dp);
        int down = findMax(grid,i+1,j,k,cost,dp);
        dp[i][j][cost] = grid[i][j] + Math.max(right,down);
        return grid[i][j] + Math.max(right,down);
    }
    public int maxPathScore(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k+1];
        for(int[][] a:dp){
            for(int[] b:a)Arrays.fill(b,-1);
        }
        int ans = findMax(grid,0,0,k,0,dp);
        if(ans<0)return -1;
        return ans;
    }
}