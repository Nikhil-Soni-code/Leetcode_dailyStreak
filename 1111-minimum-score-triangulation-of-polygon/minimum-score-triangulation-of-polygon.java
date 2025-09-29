class Solution {
    private int findMinScore(int[] values,int i,int j,int[][] dp){
        if(j-i==2){
            return values[i]*values[j]*values[i+1];
        }
        if(j-i<2)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int score = (values[i]*values[k]*values[j])+findMinScore(values,i,k,dp)+findMinScore(values,k,j,dp);
            ans = Math.min(ans,score);
        }
        dp[i][j] = ans;
        return ans;

    }
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        for(int[]a:dp)Arrays.fill(a,-1);
        return findMinScore(values,0,values.length-1,dp);
    }
}