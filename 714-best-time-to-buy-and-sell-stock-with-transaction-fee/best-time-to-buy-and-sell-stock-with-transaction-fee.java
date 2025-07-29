class Solution {
    private int find(int i,int[] prices,int fee,int boughtPreviously,int[][] dp){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][boughtPreviously]!=-1)return dp[i][boughtPreviously];
        if(boughtPreviously==1){
            int sell = prices[i]+find(i+1,prices,fee,0,dp)-fee;
            int skip = 0+find(i+1,prices,fee,1,dp);
            dp[i][boughtPreviously] = Math.max(sell,skip);
            return Math.max(sell,skip);
        }
        else{
            int buy = -prices[i]+find(i+1,prices,fee,1,dp);
            int skip = find(i+1,prices,fee,0,dp);
            dp[i][boughtPreviously] = Math.max(buy,skip);
            return Math.max(buy,skip);
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length+1][2];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return find(0,prices,fee,0,dp);
    }
}