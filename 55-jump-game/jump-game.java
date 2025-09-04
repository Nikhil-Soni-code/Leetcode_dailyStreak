class Solution {
    private boolean jump(int[] nums,int i,Boolean[] dp)
    {
        if(i==nums.length-1)return true;
        if(i>nums.length)return false;
        if(dp[i]!=null)return dp[i];

        for(int idx=1;idx<=nums[i];idx++){
            if(jump(nums,idx+i,dp)){
                dp[i] = true;
                return true;}
        }
        dp[i] = false;
        return false;
    }
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        Arrays.fill(dp,null);
        return jump(nums,0,dp);
    }
}