class Solution {
    private int minCost(int n,int[] cost,int[] dp){
        if(n<=1){
            return 0;
        }
        if(dp[n]!=-1)return dp[n];
        int cost1 = minCost(n-1,cost,dp)+cost[n-1];
        int cost2 = minCost(n-2,cost,dp)+cost[n-2];

        
        dp[n] = Math.min(cost1,cost2);
        return dp[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return minCost(cost.length,cost,dp);
    }
}