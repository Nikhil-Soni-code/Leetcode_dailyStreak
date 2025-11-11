class Solution {
    private int find(int[] nums,int i,int[] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1)return dp[i];
        int loot = nums[i]+find(nums,i+2,dp);
        int skip = 0+find(nums,i+1,dp);
        dp[i] = Math.max(loot,skip);
        return Math.max(loot,skip);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return find(nums,0,dp);
    }
}