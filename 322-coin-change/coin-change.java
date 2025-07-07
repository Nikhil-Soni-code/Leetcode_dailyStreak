// class Solution {
//     private int minCoin(int[] coins,int i,int amount,int[][] dp){
//         if(amount==0)return 0;
//         if(i==0){
//             if(amount%coins[i]==0) return amount/coins[i];
//             return MAX;
//         }
//         if(dp[i][amount]!=-1)return dp[i][amount];
//         int notPick = 0+minCoin(coins,i-1,amount,dp);
//         int pick = MAX;
//         if(amount>=coins[i]){
//             pick = 1+minCoin(coins,i,amount-coins[i],dp);
//         }
//         dp[i][amount] = Math.min(pick,notPick);
//         return dp[i][amount];
//     }
//     public int coinChange(int[] coins, int amount) {
//         int[][] dp = new int[coins.length][amount+1];
//         for(int[] a:dp){
//             Arrays.fill(a,-1);
//         }
//         int ans = minCoin(coins,coins.length-1,amount,dp);
//         return (ans==MAX)?-1:ans;
//     }
// }
class Solution {
    int MAX = 10000009;

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int amt=0;amt<=amount;amt++){
            if(amt%coins[0]==0){
                dp[0][amt] = amt/coins[0];
            }else{
                dp[0][amt] = MAX;
            }
        }
        for(int i=1;i<coins.length;i++){
            for(int amt = 0;amt<=amount;amt++){
                int notPick = dp[i-1][amt];
                int pick = MAX;
                if(amt>=coins[i]){
                    pick = 1+dp[i][amt-coins[i]];
                }
                dp[i][amt] = Math.min(notPick,pick);
            }
        }
        int ans = dp[coins.length-1][amount];
        return ans==MAX?-1:ans;
        
    }
}