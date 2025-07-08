class Solution {
    private int count(int[]coins,int amount,int i,int[][] dp){

        if(i==0)
        {
            if(amount==0)return 1;
            if(amount%coins[0]==0)return 1;
            return 0;
        }
        if(dp[i][amount]!=-1)return dp[i][amount];
        int notPick = count(coins,amount,i-1,dp);
        int pick = 0;
        if(amount>=coins[i]){
            pick = count(coins,amount-coins[i],i,dp);
        }
        dp[i][amount] = notPick+pick;
        return dp[i][amount];
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return count(coins,amount,coins.length-1,dp);
    }
}