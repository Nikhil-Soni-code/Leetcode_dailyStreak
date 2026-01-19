class Solution {
    private boolean canReach(int[] nums,int i,Boolean[]dp){
        if(i==nums.length-1)return true;
        if(dp[i]!=null)return dp[i];
        int jump = nums[i];
        for(int k=1;k<=jump;k++){
            if(canReach(nums,i+k,dp)){
                dp[i] = true;
                return true;
            }
        }
        dp[i] = false;
        return false;
    }
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        Arrays.fill(dp,null);
        return canReach(nums,0,dp);
    }
}