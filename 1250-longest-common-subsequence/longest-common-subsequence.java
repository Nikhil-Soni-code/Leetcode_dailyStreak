class Solution {
    private int count(String text1,String text2,int i1,int i2,int[][] dp){
        if(i1==0||i2==0){
            return 0;
        }
        if(dp[i1][i2]!=-1){
            return dp[i1][i2];
        }
        if(text1.charAt(i1-1)==text2.charAt(i2-1)){
            dp[i1][i2] = 1+count(text1,text2,i1-1,i2-1,dp);
            return dp[i1][i2];
        }
        dp[i1][i2] = Math.max(count(text1,text2,i1-1,i2,dp),count(text1,text2,i1,i2-1,dp));
        return dp[i1][i2];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        return count(text1,text2,text1.length(),text2.length(),dp);
    }
}
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int[][] dp = new int[text1.length()][text2.length()];
//         //base case
//         for(int i=0;i<text1.length();i++)dp[i][0];
//         for(int i=0;i<text2.length();i++)dp[0][i];


//         for(int i=1;i<text1.length();i++){
//             for(int j=1;j<text2.length();j++){
//                 if()
//             }
//         }

//     }
// }