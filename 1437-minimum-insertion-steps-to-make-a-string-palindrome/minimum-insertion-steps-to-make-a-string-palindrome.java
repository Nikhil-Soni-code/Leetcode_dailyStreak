class Solution {
    private int findMinInsertions(String s,int i,int j,int[][] dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = findMinInsertions(s,i+1,j-1,dp);
            return dp[i][j];
        }
        else{
            dp[i][j] = 1+Math.min(findMinInsertions(s,i+1,j,dp),findMinInsertions(s,i,j-1,dp));
            return dp[i][j];
        }
    }
    public int minInsertions(String s) {
        int[][]dp = new int[s.length()][s.length()];
        for(int[]a:dp)Arrays.fill(a,-1);
        return findMinInsertions(s,0,s.length()-1,dp);
    }
}