// class Solution {
//     private int findMax(int[] prices,int previouslyBought,int i,int[][]dp){
//         if(i==prices.length){
//             return 0;

//         }
//         if(dp[i][previouslyBought]!=-1)return dp[i][previouslyBought];
//         int max = 0;
//         if(previouslyBought==1){
//             int max1 = prices[i]+findMax(prices,0,i+1,dp);
//             int max2 = findMax(prices,1,i+1,dp);
//             dp[i][previouslyBought] = Math.max(max1,max2);
//             return Math.max(max1,max2);
//         }
//         else{
//             int max1 = -prices[i]+findMax(prices,1,i+1,dp);
//             int max2 = findMax(prices,0,i+1,dp);
//             dp[i][previouslyBought] = Math.max(max1,max2);
//             return Math.max(max1,max2);
//         }
//     }
//     public int maxProfit(int[] prices) {
//         int[][] dp = new int[prices.length+1][2];
//         for(int[]a:dp){
//             Arrays.fill(a,-1);
//         }
//         return findMax(prices,0,0,dp);
//     }
// }
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j==1){
                    int max1 = prices[i]+dp[i+1][0];
                    int max2 = dp[i+1][1];
                    dp[i][j] = Math.max(max1,max2);
                }
                else{
                    int max1 = -prices[i]+dp[i+1][1];
                    int max2 = dp[i+1][0];
                    dp[i][j] = Math.max(max1,max2);
                }
            }
        }
        return dp[0][0];

    }
}