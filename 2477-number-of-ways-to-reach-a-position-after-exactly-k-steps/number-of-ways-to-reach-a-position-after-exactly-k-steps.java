class Solution {
    int MOD = 1000000007;
    private int count(int startPos,int endPos,int k,int curr,int[][]dp){
        if(k==0){
            if(curr==endPos){
                return 1;
            }
            return 0;
        }
        if(dp[k][curr+1000]!=-1)return dp[k][curr+1000];
        dp[k][curr+1000] = (count(startPos,endPos,k-1,curr-1,dp)+count(startPos,endPos,k-1,curr+1,dp))%MOD;
        return dp[k][curr+1000];
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][]dp = new int[k+1][3001];
        for(int[]a:dp)Arrays.fill(a,-1);
        return count(startPos,endPos,k,startPos,dp);
    }
}