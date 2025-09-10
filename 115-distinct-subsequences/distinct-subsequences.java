class Solution {
    private int find(String s,String t,int i,int j,int[][] dp){
        if(j==0)return 1;
        if(i==0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            dp[i][j] = find(s,t,i-1,j-1,dp)+find(s,t,i-1,j,dp);
            return dp[i][j];
        }else{
            dp[i][j] = find(s,t,i-1,j,dp);
            return dp[i][j];
        }
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return find(s,t,s.length(),t.length(),dp);
    }
}