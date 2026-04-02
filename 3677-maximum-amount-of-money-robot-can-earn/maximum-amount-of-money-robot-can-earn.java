class Solution {
    private int findMax(int[][] coins , int i , int j , int neutralize , int[][][] dp){
        if(i==coins.length-1 && j==coins[0].length-1){
            if(coins[i][j] < 0 && neutralize > 0)return 0;
            return coins[i][j];
        }
        if(dp[i][j][neutralize] != Integer.MIN_VALUE)return dp[i][j][neutralize];
        if(coins[i][j] < 0){
            //neautralise 
            int right1 = Integer.MIN_VALUE,left1 = Integer.MIN_VALUE;
            if(j+1 < coins[0].length && neutralize>0)right1 = findMax(coins,i,j+1,neutralize-1,dp);
            if(i+1 < coins.length && neutralize>0)left1 = findMax(coins,i+1,j,neutralize-1,dp);
            int coins1 = Math.max(left1,right1);


            int right2 = Integer.MIN_VALUE,left2 = Integer.MIN_VALUE;
            if(j+1 < coins[0].length)right2 = findMax(coins,i,j+1,neutralize,dp);
            if(i+1 < coins.length)left2 = findMax(coins,i+1,j,neutralize,dp);
            int bestNext = Math.max(right2,left2);
            int coins2 = Integer.MIN_VALUE;

            
            if(bestNext != Integer.MIN_VALUE)coins2 = coins[i][j] + bestNext;
            dp[i][j][neutralize] = Math.max(coins1,coins2);
            return Math.max(coins1,coins2);



        }
        else {
            int right = Integer.MIN_VALUE,left = Integer.MIN_VALUE;
            if(j+1 < coins[0].length)right = findMax(coins,i,j+1,neutralize,dp);
            if(i+1 < coins.length)left = findMax(coins,i+1,j,neutralize,dp);

            int bestNext = Math.max(right,left);
            if(bestNext == Integer.MIN_VALUE) return Integer.MIN_VALUE;
            dp[i][j][neutralize] = coins[i][j] + bestNext;

            return coins[i][j] + bestNext;

        }
    }
    public int maximumAmount(int[][] coins) {
        int[][][] dp = new int[coins.length][coins[0].length][3];
        for(int [][]a:dp){
            for(int[]b:a)Arrays.fill(b,Integer.MIN_VALUE);
        }
        return findMax(coins,0,0,2,dp);
    }
}