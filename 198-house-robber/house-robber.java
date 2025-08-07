class Solution {
    private int find(int[] nums,int i,int[] dp){
        if(i==0){
            return nums[i];
        }
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];

        int pick = nums[i]+find(nums,i-2,dp);
        int notPick = 0+find(nums,i-1,dp);
        dp[i] = Math.max(pick,notPick);
        return Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return find(nums,nums.length-1,dp);
    }
}