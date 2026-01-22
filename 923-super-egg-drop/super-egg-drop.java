class Solution {
    private int minNumberOfMoves(int k,int n,int[][]dp){
        if(n==0)return 0;
        if(n==1)return 1;
        if(k==1)return n;
        if(k==0)return 0;
        if(dp[k][n]!=-1)return dp[k][n];
        int min = Integer.MAX_VALUE;

        int beg = 1,end = n;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            int broken = minNumberOfMoves(k-1,mid-1,dp);
            int unBroken = minNumberOfMoves(k,n-mid,dp);
            min = Math.min(min,1+Math.max(broken,unBroken));
            if(broken > unBroken){
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }
        dp[k][n] = min;
        return min;

    }
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        for(int[]a:dp)Arrays.fill(a,-1);
        return minNumberOfMoves(k,n,dp);
    }
}