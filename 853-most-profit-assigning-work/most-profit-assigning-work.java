class Pair{
    int d;
    int p;
    public Pair(int d,int p){
        this.d = d;
        this.p = p;
    }
}
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Pair[] pair = new Pair[difficulty.length];
        for(int i=0;i<difficulty.length;i++){
            pair[i] = new Pair(difficulty[i],profit[i]);
        }
        Arrays.sort(pair,(a,b)-> a.d-b.d);
        Arrays.sort(worker);
        int totalProfit = 0;
        for(int i=0;i<worker.length;i++){
            int j=0;
            int max = 0;
            while(j<pair.length&&pair[j].d<=worker[i]){
                max = Math.max(max,pair[j].p);j++;
            }
            totalProfit+=max;
        }
        return totalProfit;

    }
}