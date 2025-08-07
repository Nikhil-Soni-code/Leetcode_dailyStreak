class Solution {
    private boolean check(int i,int[] nums,int target,Boolean[][] dp){
        if(target==0){
            return true;
        }
        if(i<0||target<0){
            return false;
        }
        if(dp[i][target]!=null)return dp[i][target];
        dp[i][target] = check(i-1,nums,target-nums[i],dp)||check(i-1,nums,target,dp);
        return dp[i][target];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1)return false;
        int target = sum/2;
        Boolean[][] dp = new Boolean[nums.length+1][target+1];
        for(Boolean[]a:dp){
            Arrays.fill(a,null);
        }
        return check(nums.length-1,nums,target,dp);
    }
}