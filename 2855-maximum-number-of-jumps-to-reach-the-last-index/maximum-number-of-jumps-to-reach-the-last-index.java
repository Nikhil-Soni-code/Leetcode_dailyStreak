class Solution {
    private int maxJumps(int[] nums,int target,int i,int prevIdx,int[][] dp){
        if(i>=nums.length)return -1;
        if(i==nums.length-1 && prevIdx!=-1){
            if(nums[prevIdx]-nums[i] <= target && nums[prevIdx]-nums[i] >= -target){
                return 0;
            }else return -1;
        }
        if(dp[i][prevIdx+1]!=-2)return dp[i][prevIdx+1];
        int ans = -1;
        if(prevIdx==-1 ||(nums[i]-nums[prevIdx] <= target && nums[i]-nums[prevIdx] >= -target)){
            int jump1 = maxJumps(nums,target,i+1,i,dp);
            if(jump1!=-1){
                ans = 1 + jump1;
            }
            


        }
        if(i!=0){int jump2 = maxJumps(nums,target,i+1,prevIdx,dp);
        if(jump2!=-1) ans = Math.max(ans,jump2);
        dp[i][prevIdx+1] = ans;}
        return ans;
    }
    public int maximumJumps(int[] nums, int target) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] a:dp)Arrays.fill(a,-2);
        return maxJumps(nums,target,0,-1,dp);
    }
}