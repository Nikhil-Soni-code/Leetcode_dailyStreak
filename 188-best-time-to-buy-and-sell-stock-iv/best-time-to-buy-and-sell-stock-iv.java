class Solution {
    private int find(int i,int[] prices,int previouslyBought,int count,int[][][] dp,int k){
        if((count==k&&previouslyBought==0)||i==prices.length){
            return 0;
        }
        if(dp[i][previouslyBought][count]!=-1)return dp[i][previouslyBought][count];
        if(previouslyBought==1){
            int sell = prices[i]+find(i+1,prices,0,count,dp,k);
            int skip = 0+find(i+1,prices,1,count,dp,k);
            dp[i][previouslyBought][count] = Math.max(sell,skip);
            return Math.max(sell,skip);
        }
        else{
            int buy = -prices[i]+find(i+1,prices,1,count+1,dp,k);
            int skip = 0+find(i+1,prices,0,count,dp,k);
            dp[i][previouslyBought][count] = Math.max(buy,skip);
            return Math.max(buy,skip);
        }
    }
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+1][2][k+1];
        for(int[][]a:dp){
            for(int[]b:a)
            Arrays.fill(b,-1);
        }
        return find(0,prices,0,0,dp,k);
    }
}