class Solution {
    private int findLongestPalindromeSubseq(String s,int i,int j,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1)return dp[i][j];
        if(i==j)return 1;
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = 2+findLongestPalindromeSubseq(s,i+1,j-1,dp);
            return dp[i][j];
        }else{
            dp[i][j] = Math.max(findLongestPalindromeSubseq(s,i+1,j,dp),findLongestPalindromeSubseq(s,i,j-1,dp));
            return dp[i][j];
        }
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[]a:dp)Arrays.fill(a,-1);
        int ans = findLongestPalindromeSubseq(s,0,s.length()-1,dp);
        return ans;
    }
}