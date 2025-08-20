class Solution {
    private int find(int target,int[] dp){
        if(target==0){
            return 0;
        }
        if(dp[target]!=-1)return dp[target];
        int min = target;
        for(int i=1;i*i<=target;i++){
            if(target-(i*i) >= 0){
                min = Math.min(min,1+find(target-(i*i),dp));
            }else{
                break;
            }
        }
        dp[target]= min;
        return min;

    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
            Arrays.fill(dp,-1);
        return find(n,dp);
    }
}