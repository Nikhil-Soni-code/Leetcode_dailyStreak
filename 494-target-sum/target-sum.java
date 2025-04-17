class Solution {
    private int count(int[] nums,int target,int i,int sum){
        if(i==nums.length){
            if(sum==target)return 1;
            return 0;
        }
        return count(nums,target,i+1,sum-nums[i])+count(nums,target,i+1,sum+nums[i]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return count(nums,target,0,0);
    }
}