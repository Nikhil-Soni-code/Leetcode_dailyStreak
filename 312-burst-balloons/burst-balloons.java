class Solution {
    private int find(List<Integer> nums,int i,int j,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int ans = 0;
        for(int k=i;k<=j;k++){
            int coins = 0;
            coins += (nums.get(i-1)*nums.get(k)*nums.get(j+1))+find(nums,i,k-1,dp)+find(nums,k+1,j,dp);
            ans = Math.max(ans,coins);
        }
        dp[i][j] = ans;
        return ans;
    }
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList();
        list.add(1);
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }list.add(1);
        return find(list,1,list.size()-2,dp);
    }
}