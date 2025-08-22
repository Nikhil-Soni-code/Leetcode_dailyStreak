class Solution {
    private int find(int n,int[] dp){
        if(n==0)return 1;
        if(n==1||n==2)return n;
        if(dp[n]!=-1)return dp[n];
        int ans = 0;
        for(int i=1;i<=n;i++){
            ans+=find(i-1,dp)*find(n-i,dp);

        }
        dp[n] = ans;
        return ans;
    }
    public int numTrees(int n) {
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return find(n,dp);
    }
}