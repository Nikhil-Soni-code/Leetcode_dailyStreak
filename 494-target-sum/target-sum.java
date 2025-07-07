class Solution {
    private int count(int[] nums,int i,int target){
        if(i==0){
            if(target==0&&nums[i]==0)return 2;
            if(target==0||nums[i]==target)return 1;

            return 0;
        }
        int notPick = count(nums,i-1,target);
        int pick = 0;
        if(target>=nums[i]){
            pick = count(nums,i-1,target-nums[i]);
        }
        return pick+notPick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum<target||(sum+target)%2==1)return 0;
        target = (sum+target)/2;
        return count(nums,nums.length-1,target);
    }
}