class Solution {
    private int find(int n,int[] dp){
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        if(dp[n]!=-1)return dp[n];
        dp[n] = find(n-1,dp)+find(n-2,dp)+find(n-3,dp);
        return dp[n];
    }
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return find(n,dp);
    }
}