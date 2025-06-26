    // tc-> n
    // sc-> n+n
class Solution {

    private int rob(int str,int[] nums,int n,int[] dp){
        if(n<str)return 0;
        if(dp[n]!=-1)return dp[n];
        int notLooted = 0+rob(str,nums,n-1,dp);
        int looted = nums[n]+rob(str,nums,n-2,dp);
        dp[n] = Math.max(notLooted,looted);
        return dp[n];
        
    }
    public int rob(int[] nums) {
        int n = nums.length-1;
        if(n+1==1)return nums[0];
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans1 = rob(0,nums,n-1,dp);
        Arrays.fill(dp,-1);
        int ans2 = rob(1,nums,n,dp);
        return Math.max(ans1,ans2);

    }
}