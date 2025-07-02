class Solution {
    private int find(int[] nums,int i,int target,int sum,int[][] dp){
        if(sum==target){
            return 1;
        }
        if(sum>target)return -1;
        if(i==nums.length)return -1;
        if(dp[i][sum]!=0)return dp[i][sum];

        int pick = find(nums,i+1,target,sum+nums[i],dp);
        if(pick==1){
            dp[i][sum] = pick;
        }
        else{
            int notPick = find(nums,i+1,target,sum,dp);
            dp[i][sum] = notPick;
        }

        return dp[i][sum];

    }
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int i=0;i<nums.length;i++){
            target+=nums[i];
        }
        if(target%2==1)return false;
        int[][] dp = new int[nums.length][target/2];
        return find(nums,0,target/2,0,dp)==1;
    }
}