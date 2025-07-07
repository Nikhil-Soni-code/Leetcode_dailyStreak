class Solution {
    int MAX = 10000009;
    private int minCoin(int[] coins,int i,int amount,int[][] dp){
        if(amount==0)return 0;
        if(i==0){
            if(amount%coins[i]==0) return amount/coins[i];
            return MAX;
        }
        if(dp[i][amount]!=-1)return dp[i][amount];
        int notPick = 0+minCoin(coins,i-1,amount,dp);
        int pick = MAX;
        if(amount>=coins[i]){
            pick = 1+minCoin(coins,i,amount-coins[i],dp);
        }
        dp[i][amount] = Math.min(pick,notPick);
        return dp[i][amount];
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        int ans = minCoin(coins,coins.length-1,amount,dp);
        return (ans==MAX)?-1:ans;
    }
}