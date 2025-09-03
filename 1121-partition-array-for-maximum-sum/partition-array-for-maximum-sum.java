class Solution {
    private int findMax(int[] arr,int i,int k,int[] dp){
        if(i==arr.length){
            return 0;
        }
        if(dp[i]!=-1)return dp[i];
        int ans = 0,max = 0;
        for(int idx=i;idx<Math.min(arr.length,i+k);idx++){
            max = Math.max(max,arr[idx]);
            int sum = max*(idx-i+1) + findMax(arr,idx+1,k,dp);
            ans = Math.max(ans,sum);
        }
        dp[i] = ans;
        return ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return findMax(arr,0,k,dp);
    }
}