class Solution {
    private int find(String s , String t , int i, int j,int[][] dp){
        if(j<0)return 1;
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int ans = 0;
        if(s.charAt(i)==t.charAt(j)){
            ans += find(s,t,i-1,j-1,dp);
        }
        dp[i][j] = ans + find(s,t,i-1,j,dp);
        return dp[i][j];
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        return find(s,t,s.length()-1,t.length()-1,dp);
    }
}