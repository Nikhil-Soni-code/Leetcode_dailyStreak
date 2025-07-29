class Solution {
    private int findMax(int[] prices,int previouslyBought,int i,int[][]dp){
        if(i==prices.length){
            return 0;

        }
        if(dp[i][previouslyBought]!=-1)return dp[i][previouslyBought];
        int max = 0;
        if(previouslyBought==1){
            int max1 = prices[i]+findMax(prices,0,i+1,dp);
            int max2 = findMax(prices,1,i+1,dp);
            dp[i][previouslyBought] = Math.max(max1,max2);
            return Math.max(max1,max2);
        }
        else{
            int max1 = -prices[i]+findMax(prices,1,i+1,dp);
            int max2 = findMax(prices,0,i+1,dp);
            dp[i][previouslyBought] = Math.max(max1,max2);
            return Math.max(max1,max2);
        }
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return findMax(prices,0,0,dp);
    }
}