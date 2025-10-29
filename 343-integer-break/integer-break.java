// class Solution {
//     private int find(int n,int[] dp){
//         if(n<=2)return 1;
//         if(dp[n]!=-1)return dp[n];
//         int product = 1;
//         for(int i=1;i<=n-1;i++){
//             product = Math.max(product,i*Math.max(n-i,find(n-i,dp)));
//         }
//         dp[n] = product;
//         return product;
//     }
//     public int integerBreak(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp,-1);
//         return find(n,dp);
//     }
// }
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            int product = 1;
            for(int j=1;j<=i-1;j++){
                product = Math.max(product,j*Math.max(i-j,dp[i-j]));
            }
            dp[i] = product;
        }
        return dp[n];
    }
}