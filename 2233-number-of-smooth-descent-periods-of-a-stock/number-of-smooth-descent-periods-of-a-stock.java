class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 1;
        int i = 0 , j = 1;
        while(j < prices.length){
            if(prices[j-1] - prices [j] != 1){
                i = j;
            }
            ans +=  j -i+1;
            j++;
        }return ans;
    }
}