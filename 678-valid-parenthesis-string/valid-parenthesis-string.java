class Solution {
    private boolean check(String s,int i,int open,Boolean[][] dp){
        if(open<0)return false;
        if(i==s.length())return open==0;
        if(dp[i][open]!=null)return dp[i][open];
        if(s.charAt(i)=='('){
            dp[i][open] = check(s,i+1,open+1,dp);
            return dp[i][open];
        }
        else if(s.charAt(i)==')'){
            dp[i][open] = check(s,i+1,open-+1,dp);
            return dp[i][open];
        }
        else{
            dp[i][open] = check(s,i+1,open+1,dp)||check(s,i+1,open-1,dp)||check(s,i+1,open,dp);
            return dp[i][open];
        }
    }
    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        for(Boolean[] a:dp)Arrays.fill(a,null);
        return check(s,0,0,dp);
    }
}