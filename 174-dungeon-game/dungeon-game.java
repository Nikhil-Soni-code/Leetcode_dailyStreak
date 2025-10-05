class Solution {
    private int find(int[][] dungeon,int i,int j,int[][] dp){
        if(i==dungeon.length-1&&j==dungeon[0].length-1){
            if(dungeon[i][j]<=0){
                return Math.abs(dungeon[i][j])+1;
            }else{
                return 1;
            }
        }
        if(i==dungeon.length||j==dungeon[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int bottom = find(dungeon,i+1,j,dp);
        int right = find(dungeon,i,j+1,dp);
        int min = Math.min(bottom,right);

        dp[i][j] = Math.max(1,min-dungeon[i][j]);
        return dp[i][j];
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for(int[]a:dp)Arrays.fill(a,-1);
        return find(dungeon,0,0,dp);
    }
}