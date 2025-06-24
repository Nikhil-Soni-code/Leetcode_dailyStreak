
//TLE
// class Solution {
//     private int climb(int n,int i){
//         if(i>n)return 0;
//         if(i==n)return 1;
//         return climb(n,i+1)+climb(n,i+2);
//     }
//     public int climbStairs(int n) {
//         //Try with the recurssion part 
//         // then use memoisation
//         return climb(n,0);
        
//     }
// }
class Solution {
    private int climb(int n,int[] dp){
        if(n<=1)return 1;
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = climb(n-1,dp)+climb(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climb(n,dp);
    }
}