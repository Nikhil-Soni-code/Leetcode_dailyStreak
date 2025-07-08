// class Solution {
//     private int count(int[]coins,int amount,int i,int[][] dp){

//         if(i==0)
//         {
//             if(amount%coins[0]==0)return 1;
//             return 0;
//         }
//         if(dp[i][amount]!=-1)return dp[i][amount];
//         int notPick = count(coins,amount,i-1,dp);
//         int pick = 0;
//         if(amount>=coins[i]){
//             pick = count(coins,amount-coins[i],i,dp);
//         }
//         dp[i][amount] = notPick+pick;
//         return dp[i][amount];
//     }
//     public int change(int amount, int[] coins) {
//         int[][] dp = new int[coins.length][amount+1];
//         for(int[]a:dp){
//             Arrays.fill(a,-1);
//         }
//         return count(coins,amount,coins.length-1,dp);
//     }
// }
// class Solution {
//     public int change(int amount, int[] coins) {
//         int[][] dp = new int[coins.length][amount+1];
//         for(int amt = 0;amt <= amount;amt++){
//             if(amt%coins[0]==0)dp[0][amt] = 1;
//             else dp[0][amt] = 0;
//         }
//         for(int i=1;i<coins.length;i++){
//             for(int amt=0;amt<=amount;amt++){
//                 int notPick = dp[i-1][amt];
//                 int pick = 0;
//                 if(amt>=coins[i]){
//                     pick = dp[i][amt-coins[i]];
//                 }
//                 dp[i][amt] = notPick+pick;
//             }
//         }
//         return dp[coins.length-1][amount];

//     }
// }
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        for(int amt=0;amt<=amount;amt++){
            if(amt%coins[0]==0)dp[amt] = 1;
            else dp[amt] = 0;
        }
        for(int i=1;i<coins.length;i++){
            for(int amt=0;amt<=amount;amt++){
                int notPick = dp[amt];
                int pick = 0;
                if(amt>=coins[i]){
                    pick = dp[amt-coins[i]];
                }
                dp[amt] = notPick+pick;
            }
        }
        return dp[amount];
    }
}