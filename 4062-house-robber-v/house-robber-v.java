class Solution {
    private long find(int[] nums,int[] colors,int i,int previosulyChosen,long[][]dp){
        if(i>=nums.length)return 0;
        if(dp[i][previosulyChosen] != -1)return dp[i][previosulyChosen];
        long pick = 0,skip1 = 0;
        if(previosulyChosen == 0 || (previosulyChosen == 1 && colors[i-1] != colors[i])){
            pick = nums[i] + find(nums,colors,i+1,1,dp);
        }
        else if(previosulyChosen == 1 && colors[i-1] == colors[i]){
            skip1 = find(nums,colors,i+1,0,dp);
        }
        long skip = find(nums,colors,i+1,0,dp);

        dp[i][previosulyChosen] = Math.max(skip,Math.max(pick,skip1));
        return Math.max(skip,Math.max(pick,skip1));
    }
    public long rob(int[] nums, int[] colors) {
        long[][] dp = new long[nums.length][2];
        for(long[]a:dp){
            Arrays.fill(a,-1);
        }
        return find(nums,colors,0,0,dp);
    }
}