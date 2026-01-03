class Solution {
    // previouslyBought = 1 yess
    // previouslyBought = 0 nooo

    private int buyOrSell(int[] prices,int fee,int i,int previouslyBought,int[][] dp){
        if(i==prices.length)return 0;
        if(dp[i][previouslyBought] != -1)return dp[i][previouslyBought];
        int buy = 0,sell = 0;
        if(previouslyBought==0){
            buy = -fee - prices[i] + buyOrSell(prices,fee,i+1,1,dp);
        }
        else{
            sell = prices[i] + buyOrSell(prices,fee,i+1,0,dp);
        }
        int hold = buyOrSell(prices,fee,i+1,previouslyBought,dp);
        dp[i][previouslyBought] = Math.max(buy,Math.max(sell,hold));
        return Math.max(buy,Math.max(sell,hold));
    }
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return buyOrSell(prices,fee,0,0,dp);
    }
}