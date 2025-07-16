class Solution {
    private int count(int n , int i, int[][] dp){
        if(n==0){
            return 1;

        }
        if(dp[n][i]!=-1){
            return dp[n][i];
        }
        int counter = 0;
        if(i==0)
        {
            counter=count(n-1,0,dp)+count(n-1,1,dp)+count(n-1,2,dp)+count(n-1,3,dp)+count(n-1,4,dp);
            dp[n][i] = counter;
        }
                if(i==1)
        {
            counter+=count(n-1,1,dp)+count(n-1,2,dp)+count(n-1,3,dp)+count(n-1,4,dp);
            dp[n][i] = counter;

        }
                if(i==2)
        {
            counter+=count(n-1,2,dp)+count(n-1,3,dp)+count(n-1,4,dp);
            dp[n][i] = counter;

           
        }
                if(i==3)
        {
            counter+=count(n-1,3,dp)+count(n-1,4,dp);
            dp[n][i] = counter;

        }
                if(i==4)
        {
            counter+=count(n-1,4,dp);
            dp[n][i] = counter;

        }
        return counter;
    }
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][5];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return count(n,0,dp);
    }
}