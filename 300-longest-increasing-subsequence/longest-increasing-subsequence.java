class Solution {
    private int findMaxLength(int[] nums,int i,int prev,int[][]dp){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1] != -1)return dp[i][prev+1];
        int pick = 0;
        if(prev==-1 || nums[i] > nums[prev]){
            pick = 1 + findMaxLength(nums,i+1,i,dp);
        }
        int notPick = findMaxLength(nums,i+1,prev,dp);
        dp[i][prev+1] = Math.max(pick,notPick);
        return Math.max(pick,notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return findMaxLength(nums,0,-1,dp);
    }
}