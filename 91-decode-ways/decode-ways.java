class Solution {
    private int decode(String s , int i,int [] dp){
        if(i==s.length())return 1;
        if(s.charAt(i)=='0')return 0;
        if(dp[i]!=-1)return dp[i];
        int pickOne = decode(s,i+1,dp);
        int pickTwo = 0;

        if(i<s.length()-1){
            int num = Integer.parseInt((""+s.charAt(i)+s.charAt(i+1)));
            if(num<=26)
            pickTwo = decode(s,i+2,dp);
        }
        dp[i] = pickOne+pickTwo;
        return pickOne+pickTwo;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return decode(s,0,dp);
    }
}