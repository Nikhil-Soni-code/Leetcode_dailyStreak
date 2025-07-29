class Solution {
    private int find(int i,int[] nums,int prev,int[][] dp){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
        int pick = 0,notPick = 0;
        if(prev==-1||nums[prev]<nums[i]){
            pick = 1+find(i+1,nums,i,dp);
        }
        notPick = 0+find(i+1,nums,prev,dp);
        dp[i][prev+1] = Math.max(pick,notPick);
        return Math.max(pick,notPick);

    }
    public int lengthOfLIS(int[] nums) {
        int[][]dp = new int[nums.length][nums.length];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return find(0,nums,-1,dp);
    }
}