class Solution {
    private int lcs(String s1,String s2,int i,int j,int[][] dp){
        if(i==0||j==0)return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            dp[i][j] = 1+lcs(s1,s2,i-1,j-1,dp);
            return dp[i][j];
        }
        else{
            dp[i][j] = Math.max(lcs(s1,s2,i-1,j,dp),lcs(s1,s2,i,j-1,dp));
            return dp[i][j];
        }
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        lcs(str1,str2,str1.length(),str2.length(),dp);
        int i=str1.length(),j=str2.length();
        StringBuilder sbr = new StringBuilder();
        while(i>0||j>0){
            if(i==0){
                sbr.append(str2.charAt(j-1));
                j--;
            }
            else if(j==0){
                sbr.append(str1.charAt(i-1));
                i--;
            }
            else if(str1.charAt(i-1)==str2.charAt(j-1)){
                sbr.append(str1.charAt(i-1));
                i--;j--;
            }
            else{

                if(dp[i-1][j]>dp[i][j-1]){
                    sbr.append(str1.charAt(i-1));
                    i--;
                }
                else{
                    sbr.append(str2.charAt(j-1));
                    j--;
                }
            }
        }
        return sbr.reverse().toString();
    }
}