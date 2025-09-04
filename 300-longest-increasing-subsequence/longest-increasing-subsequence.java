class Solution {
    private int find(int[] nums,int i,int prev,int[][] dp){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=10002)return dp[i][prev+1];
        int pick = -1;
        if(prev==-1||nums[i]>nums[prev]){
            pick = 1+find(nums,i+1,i,dp);
        }
        int notPick = find(nums,i+1,prev,dp);
        dp[i][prev+1] = Math.max(pick,notPick);
        return Math.max(pick,notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int[]a:dp){
            Arrays.fill(a,10002);
        }
        return find(nums,0,-1,dp);
    }
}