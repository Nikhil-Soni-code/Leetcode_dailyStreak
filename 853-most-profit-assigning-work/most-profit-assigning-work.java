class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDiff = 0;
        for(int i=0;i<difficulty.length;i++){
            maxDiff = Math.max(maxDiff,difficulty[i]);
        }
        int maxPot = 0;
        for(int i=0;i<worker.length;i++){
            maxPot = Math.max(maxPot,worker[i]);
        }
        int[] bucket = new int[Math.max(maxPot,maxDiff)+1];
        for(int i=0;i<difficulty.length;i++){
            bucket[difficulty[i]] = Math.max(bucket[difficulty[i]],profit[i]);
        }
        int maxProfit = 0;
        for(int i=0;i<bucket.length;i++){
            maxProfit = Math.max(maxProfit,bucket[i]);
            bucket[i] = Math.max(bucket[i],maxProfit);
        }
        int netProfit = 0;
        for(int i=0;i<worker.length;i++){
            netProfit+=bucket[worker[i]];
        }return netProfit;

    }
}