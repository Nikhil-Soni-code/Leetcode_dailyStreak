class Solution {
    private int rob(int[] nums,int n,int[] dp){
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        int notLooted = 0+rob(nums,n-1,dp);
        int looted = nums[n]+rob(nums,n-2,dp);
        dp[n] = Math.max(notLooted,looted);
        return dp[n];
        
    }
    public int rob(int[] nums) {
        int n = nums.length-1;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return rob(nums,n,dp);
    }
}
// class Solution {
//     //tc -> 2^n
//     //sc -> n
//     private int rob(int[] nums,int n){
//         if(n<0)return 0;
//         int notLooted = 0+rob(nums,n-1);
//         int looted = nums[n]+rob(nums,n-2);

//         return Math.max(notLooted,looted);
        
//     }
//     public int rob(int[] nums) {
//         int n = nums.length-1;
//         return rob(nums,n);
//     }
// }