class Solution {
    private int buyOrSell(int[] prices,int i,int previouslyBought,int[][]dp){
        if(i>=prices.length)return 0;
        if(dp[i][previouslyBought]!=-1)return dp[i][previouslyBought];
        int buy = 0,sell = 0;

        if(previouslyBought==0){
            buy = -prices[i] + buyOrSell(prices,i+1,1,dp);
        }
        else{
            sell = prices[i] + buyOrSell(prices,i+2,0,dp);
        }
        int hold = buyOrSell(prices,i+1,previouslyBought,dp);
        dp[i][previouslyBought] = Math.max(buy,Math.max(sell,hold));
        return dp[i][previouslyBought];
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return buyOrSell(prices,0,0,dp);
    }
}