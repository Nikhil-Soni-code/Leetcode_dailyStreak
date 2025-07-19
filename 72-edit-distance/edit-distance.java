class Solution {
    private int edit(String word1,String word2,int i,int j,int[][] dp){
        if(j==0){
            return i;
        }
        if(i==0){
            return j;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        if(word1.charAt(i-1)==word2.charAt(j-1)){
            dp[i][j] = edit(word1,word2,i-1,j-1,dp);
            return dp[i][j];
        }
        else{
            int insert = 1+edit(word1,word2,i,j-1,dp);
            int delete = 1+edit(word1,word2,i-1,j,dp);
            int replace = 1+edit(word1,word2,i-1,j-1,dp);

            dp[i][j] = Math.min(insert,Math.min(delete,replace));
            return dp[i][j];
        }
    }
    public int minDistance(String word1, String word2) {
        if(word1.length()==0){
            return word2.length();
        }
        if(word2.length()==0){
            return word1.length();
        }
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return edit(word1,word2,word1.length(),word2.length(),dp);
    }
}