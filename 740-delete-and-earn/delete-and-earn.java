class Solution {
    private int findMax(int[] occur , int i, int[] dp){
        if(i>=occur.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int take = (occur[i]*i) + findMax(occur,i+2,dp);
        int notTake = 0 + findMax(occur,i+1,dp);

        dp[i] = Math.max(take,notTake);
        return Math.max(take,notTake);
    }
    public int deleteAndEarn(int[] nums) {
        int max = -1;
        for(int i=0 ; i<nums.length ; i++){
            max = Math.max(max,nums[i]);
        }
        int[] occur = new int[max+1];
        for(int i=0 ; i<nums.length ; i++){
            occur[nums[i]]++;
        }
        int[] dp = new int[occur.length];
        Arrays.fill(dp,-1);
        return findMax(occur,0,dp);
    }
}