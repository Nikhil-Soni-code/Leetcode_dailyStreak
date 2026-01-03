class Solution {
    private int buyOrSell(int[] prices,int i,int k,int previouslyBought,int[][][] dp){
        if(k==0 || i>= prices.length)return 0;
        if(dp[i][k][previouslyBought] != -1)return dp[i][k][previouslyBought];
        int buy = 0,sell = 0;
        if(previouslyBought == 0){
            buy = -prices[i] + buyOrSell(prices,i+1,k,1,dp);
        }else{
            sell = prices[i] + buyOrSell(prices,i+1,k-1,0,dp);
        }
        int hold = buyOrSell(prices,i+1,k,previouslyBought,dp);
        dp[i][k][previouslyBought] = Math.max(buy,Math.max(sell,hold));
        return Math.max(buy,Math.max(sell,hold));
    }
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][k+1][2];
        for(int[][] a:dp){
            for(int[]b:a)Arrays.fill(b,-1);
        }
        return buyOrSell(prices,0,k,0,dp);
    }
}