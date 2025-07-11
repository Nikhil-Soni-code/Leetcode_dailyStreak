class Solution {
    private int find(String s,int i1,int i2,int[][] dp){
        if(i1==i2)return 1;
        if(i1>=i2)return 0;
        if(dp[i1][i2]!=-1)return dp[i1][i2];
        if(s.charAt(i1)==s.charAt(i2)){
            dp[i1][i2] = 2+find(s,i1+1,i2-1,dp);
            return dp[i1][i2];
        }
        else{
            dp[i1][i2] = Math.max(find(s,i1+1,i2,dp),find(s,i1,i2-1,dp));
            return dp[i1][i2];
        }
    }
    public int longestPalindromeSubseq(String s) {
        if(s.length()==1)return 1;
        int[][] dp = new int[s.length()][s.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return find(s,0,s.length()-1,dp);


    }
}