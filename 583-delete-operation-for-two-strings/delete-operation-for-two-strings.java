class Solution {
    private int minOperation(String word1,String word2,int i,int j,int[][] dp){
        if(i==word1.length()||j==word2.length()){
            if(i==word1.length())return word2.length()-j;
            if(j==word2.length())return word1.length()-i;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j] = minOperation(word1,word2,i+1,j+1,dp);
            return dp[i][j];
        }
        else{
            dp[i][j] = 1+Math.min(minOperation(word1,word2,i+1,j,dp),minOperation(word1,word2,i,j+1,dp));
            return dp[i][j];
        }
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return minOperation(word1,word2,0,0,dp);
    }
}