class Pair{
    int start;
    int end;
    int profit;
    public Pair(int start,int end,int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
class Solution {
    private int binarySearchForNearestJob(List<Pair> list , int i , int target){
        int beg = i,end = list.size()-1;
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            if(list.get(mid).start >= target){
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }
        return beg;
    }
    private int findMaxProfit(List<Pair> list , int i,int[] dp){
        if(i == list.size()){
            return 0;
        }
        if(dp[i] != -1)return dp[i];
        int notTake = findMaxProfit(list , i+1 , dp);
        int next = binarySearchForNearestJob(list,i+1,list.get(i).end);
        int take = list.get(i).profit + findMaxProfit(list , next ,dp);

        dp[i] = Math.max(notTake , take); 
        return Math.max(notTake , take);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Pair> list = new ArrayList();
        for(int i=0 ; i<startTime.length ; i++){
            list.add(new Pair(startTime[i] , endTime[i] , profit[i]));
        }
        int[] dp = new int[startTime.length];
        Arrays.fill(dp,-1);
        Collections.sort(list,(a,b) -> a.start - b.start);
        return findMaxProfit(list,0,dp);

    }
}