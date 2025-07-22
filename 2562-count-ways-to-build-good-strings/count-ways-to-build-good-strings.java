class Solution {
    int MOD = 1_000_000_007;
    private int count(int low,int high,int zero,int one,int length,int[] dp){
        // if(length>high){
        //     return 0;
        // }
        if(dp[length]!=-1)return dp[length];
        int counter = 0;
        if(length>=low&&length<=high)counter++;
        if(length+zero<=high){
            counter=(counter+count(low,high,zero,one,length+zero,dp))%MOD;
        }
        if(length+one<=high){
            counter=(counter+count(low,high,zero,one,length+one,dp))%MOD;
        }
        dp[length] = counter%MOD;
        return dp[length];
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        Arrays.fill(dp,-1);
        return count(low,high,zero,one,0,dp);
    }
}