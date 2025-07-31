class Solution {
    int MOD = 1000000007;
    private int count(int i,int target,int n,int x,int[][] dp){
        if(target==0){
            return 1;
        }
        if(target<0||i>n)return 0;
        if(dp[i][target]!=-1)return dp[i][target];
        int take = (count(i+1,target-(int)Math.pow(i,x),n,x,dp))%MOD;
        int notTake = (count(i+1,target,n,x,dp))%MOD;
        dp[i][target] = (take+notTake)%MOD;
        return dp[i][target];
    }
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][n+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return count(1,n,n,x,dp);
    }
}