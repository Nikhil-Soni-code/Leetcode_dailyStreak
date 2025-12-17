class Solution {
    private long find(int[] prices,int i,int k,int boughtEarlier,long[][][] dp){
        if(k==0)return 0;
        if(i==prices.length-1){
            if(boughtEarlier==1){
                return prices[i];
            }else if(boughtEarlier==2){
                return -prices[i];
            }return 0;
        }
        if(dp[i][k][boughtEarlier] != -1)return dp[i][k][boughtEarlier];
        if(boughtEarlier == 1){
            long a = prices[i] + find(prices,i+1,k-1,0,dp);//sell
            long b = find(prices,i+1,k,boughtEarlier,dp);//hold
            dp[i][k][boughtEarlier] = Math.max(a,b);
            return dp[i][k][boughtEarlier];
        }
        else if(boughtEarlier==0){
            long a = -prices[i] + find(prices,i+1,k,1,dp);//buy
            long b = find(prices,i+1,k,0,dp);//wait
            long c = prices[i] + find(prices,i+1,k,2,dp);
            dp[i][k][boughtEarlier] = Math.max(a,Math.max(b,c));
            return dp[i][k][boughtEarlier];
        }else{
            long a = -prices[i] + find(prices,i+1,k-1,0,dp);
            long b = find(prices,i+1,k,2,dp);
            dp[i][k][boughtEarlier] = Math.max(a,b);
            return dp[i][k][boughtEarlier];
        }
    }
    public long maximumProfit(int[] prices, int k) {
        long[][][] dp = new long[prices.length][k+1][3];
        for(long[][] a:dp){
            for(long[]b:a){
                Arrays.fill(b,-1);
            }
        }

        return find(prices,0,k,0,dp);
    }
}

// class Solution {
//     private long find(int[] prices,int i,int k,int buy,int sell,long profit){
//         if(k==0 || i==prices.length){
//             return profit;
//         }
//         long maxProfit = find(prices,i+1,k,buy,sell,profit);
//         if(buy != -1){
//             if(buy < prices[i]){
//                 maxProfit = Math.max(maxProfit,find(prices,i+1,k-1,-1,sell,profit+prices[i]-buy));} //sell
//         }
//         else if(sell != -1){
//             if(sell > prices[i]){
//                 maxProfit = Math.max(maxProfit,find(prices,i+1,k-1,buy,-1,profit+sell-prices[i]));} //buy
//         }else{
//             long a = find(prices,i+1,k,prices[i],sell,profit); //buy
//             long b = find(prices,i+1,k,buy,prices[i],profit); //sell
//             maxProfit = Math.max(maxProfit,Math.max(a,b));
//         }
//         return maxProfit;

//     }
//     public long maximumProfit(int[] prices, int k) {
//         return find(prices,0,k,-1,-1,0);
//     }
// }