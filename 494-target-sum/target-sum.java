class Solution {
    private int count(int[] nums,int i,int target,int[][]dp){
        if(i==0){
            if(target==0&&nums[i]==0)return 2;
            if(target==0||nums[i]==target)return 1;

            return 0;
        }
        if(dp[i][target+1000]!=-1)return dp[i][target+1000];
        int notPick = count(nums,i-1,target,dp);
        int pick = 0;
        if(target>=nums[i]){
            pick = count(nums,i-1,target-nums[i],dp);
        }
        dp[i][target+1000] = pick+notPick;
        return dp[i][target+1000];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
    
        if(sum<target||(sum+target)%2==1)return 0;
        target = (sum+target)/2;
        int[][]dp = new int[nums.length][target+1001];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return count(nums,nums.length-1,target,dp);
    }
}
// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
        
//     }
// }