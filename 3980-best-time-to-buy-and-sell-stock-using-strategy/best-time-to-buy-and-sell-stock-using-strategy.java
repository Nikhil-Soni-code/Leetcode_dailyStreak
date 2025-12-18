class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long[] profit = new long[prices.length];
        long[] prefix = new long[prices.length];
        profit[0] = prices[0]*strategy[0];
        prefix[0] = prices[0];
        for(int i=1;i<prices.length;i++){
            profit[i] = profit[i-1]+((long)prices[i]*strategy[i]);
            prefix[i] = (long)prefix[i-1]+prices[i];
        }
        long ans = profit[profit.length-1];
        long max = 0;
        int i=0,j = k-1;
        while(j < prices.length){
            long modified = prefix[j]-prefix[j-(k/2)];
            long old = profit[j] - ((i==0)?0:profit[i-1]);
            max = Math.max(max, modified-old);
            j++;i++;
        }
        return ans+max;
    }
}