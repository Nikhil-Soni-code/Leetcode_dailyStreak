class Solution {
    private int find(int[] coins,int i,int amount,int[][] dp){
        if(amount==0)return 0;
        if(i==coins.length)return 10000000;
        if(dp[i][amount]!=-1)return dp[i][amount];
        long pick = 10000000,notPick;
        if(amount>=coins[i]){
            pick = 1+find(coins,i,amount-coins[i],dp);
        }
        notPick = find(coins,i+1,amount,dp);
        dp[i][amount] = (int)Math.min(pick,notPick);
        return (int)Math.min(pick,notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        int ans = find(coins,0,amount,dp);
        return ans==10000000?-1:ans;
    }
}