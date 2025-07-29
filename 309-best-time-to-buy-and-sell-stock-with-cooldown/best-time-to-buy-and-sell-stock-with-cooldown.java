class Solution {
    private int find(int i,int[] prices,int previouslyBought,int cooldown,int[][][] dp){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][previouslyBought][cooldown]!=-1)return dp[i][previouslyBought][cooldown];
        if(cooldown==1){
            dp[i][previouslyBought][cooldown] = find(i+1,prices,0,0,dp);
            return find(i+1,prices,0,0,dp);
        }
        if(previouslyBought==1){
            int sell = prices[i]+find(i+1,prices,0,1,dp);
            int skip = 0+find(i+1,prices,1,0,dp);
            dp[i][previouslyBought][cooldown] = Math.max(sell,skip);
            return Math.max(sell,skip);
        }
        else{
            int buy = -prices[i]+find(i+1,prices,1,0,dp);
            int skip = 0+find(i+1,prices,0,0,dp);
            dp[i][previouslyBought][cooldown] = Math.max(buy,skip);
            return Math.max(buy,skip);
        }
    }
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][2];
        for(int [][]a:dp){
            for(int[]b:a){
                Arrays.fill(b,-1);
            }
        }
        return find(0,prices,0,0,dp);
    }
}