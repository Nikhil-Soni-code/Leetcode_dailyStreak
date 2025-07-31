// class Solution {
//     private int count(int[] nums,int target,int[]dp){
//         if(target==0)return 1;
//         if(target<0)return 0;
//         if(dp[target]!=-1)return dp[target];
//         int counter = 0;
//         for(int i=0;i<nums.length;i++){
//             counter+=count(nums,target-nums[i],dp);
//         }
//         dp[target] = counter;
//         return counter;
//     }
//     public int combinationSum4(int[] nums, int target) {
//         int[] dp = new int[target+1];
//         Arrays.fill(dp,-1);
//         return count(nums,target,dp);
//     }
// }
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int t=1;t<=target;t++){
            int counter = 0;
            for(int i=0;i<nums.length;i++){
                if(t-nums[i]>=0){
                    counter+=dp[t-nums[i]];
                }
            }
            dp[t] = counter;
        }
        return dp[target];
    }
}