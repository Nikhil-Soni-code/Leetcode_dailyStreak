class Solution {
    private int findLongestIdealString(String s,int i,int k,int lastASCII,int[][] dp){
        if(i==s.length()){
            return 0;
        }
        if(lastASCII!=200&&dp[i][lastASCII-97]!=-1)return dp[i][lastASCII-97];
        int include = 0;
        if(lastASCII==200||Math.abs(lastASCII-(int)s.charAt(i))<=k){
            include = 1+findLongestIdealString(s,i+1,k,(int)s.charAt(i),dp);
        }
        int notInclude = findLongestIdealString(s,i+1,k,lastASCII,dp);
        if(lastASCII!=200)dp[i][lastASCII-97] = Math.max(include,notInclude);
        return Math.max(include,notInclude);
    }
    public int longestIdealString(String s, int k) {
        int[][] dp = new int[s.length()][26];
        for(int[]a:dp)Arrays.fill(a,-1);
        return findLongestIdealString(s,0,k,200,dp);
    }
}