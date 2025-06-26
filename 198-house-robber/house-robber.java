class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n];
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int max1 = nums[i]+dp[i-2];// take current
            int max2 = 0+dp[i-1];//leave current

            dp[i] = Math.max(max1,max2);
        }
        return dp[n-1];

    }
}
// class Solution {
//     // tc-> n
//     // sc-> n+n
//     private int rob(int[] nums,int n,int[] dp){
//         if(n<0)return 0;
//         if(dp[n]!=-1)return dp[n];
//         int notLooted = 0+rob(nums,n-1,dp);
//         int looted = nums[n]+rob(nums,n-2,dp);
//         dp[n] = Math.max(notLooted,looted);
//         return dp[n];
        
//     }
//     public int rob(int[] nums) {
//         int n = nums.length-1;
//         int[] dp = new int[n+1];
//         Arrays.fill(dp,-1);
//         return rob(nums,n,dp);
//     }
// }
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