class Solution {
    private boolean match(String s,String p,int i,int j,Boolean[][] dp){
        if(i<0 && j<0){
            return true;
        }
        if(i<0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k) != '*')return false;
            }
            return true;
        }
        if(j<0){
            return false;
        }
        if(dp[i][j] != null)return dp[i][j];
        if(p.charAt(j)=='?' || s.charAt(i) == p.charAt(j)){
            dp[i][j] = match(s,p,i-1,j-1,dp);
            return dp[i][j];
        }else if(p.charAt(j) == '*'){
            for(int k=i;k>=-1;k--){
                if(match(s,p,k,j-1,dp)){
                    dp[i][j] = true;
                    return true;
                }
            }
        }
        dp[i][j] = false;
        return false;
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        for(Boolean b[]:dp){
            Arrays.fill(b,null);
        }
        return match(s,p,s.length()-1,p.length()-1,dp);
    }
}