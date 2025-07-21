
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
// _________________________________________________________
//Memoisation tc- O(N)....sc- O(N)
// class Solution {
//     private int climb(int n,int[] dp){
//         if(n<=1)return 1;
//         if(dp[n]!=-1){
//             return dp[n];
//         }
//         dp[n] = climb(n-1,dp)+climb(n-2,dp);
//         return dp[n];
//     }
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp,-1);
//         return climb(n,dp);
//     }
// }
// _________________________________________________________

// class Solution {
//     public int climbStairs(int n) {
//         int a = 1;
//         int b = 1;
//         int c = a+b;
//         for(int i=2;i<=n;i++){
//             c=a+b;
//             a=b;
//             b=c;
//         }
//         return b;
//     }
// }
class Solution {
    private int count(int n,int[]dp){
        if(n==0)return 1;
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        dp[n]=count(n-1,dp)+count(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return count(n,dp);
    }
}