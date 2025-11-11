class Solution {
    private int[] countNoOf0And1(String s){
        int zero = 0,one = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')one++;
            else zero++;
        }
        return new int[]{zero,one};
    }
    private int findMaxNum(String[] str,int m,int n,int i,int[][][] dp){
        if(i==str.length)return 0;
        if(m==0&&n==0)return 0;
        if(dp[m][n][i]!=-1)return dp[m][n][i];
        int[] pair = countNoOf0And1(str[i]);
        int one = pair[1];
        int zero = pair[0];
        int pick = 0,notPick = 0;
        if(m>=zero&&n>=one){
            pick = 1 + findMaxNum(str,m-zero,n-one,i+1,dp);
        }
        notPick = findMaxNum(str,m,n,i+1,dp);
        dp[m][n][i] = Math.max(pick,notPick);
        return Math.max(pick,notPick);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m+1][n+1][strs.length];
        for(int[][]a:dp){
            for(int[]b:a){
                Arrays.fill(b,-1);
            }
        }
        return findMaxNum(strs,m,n,0,dp);
    }
}