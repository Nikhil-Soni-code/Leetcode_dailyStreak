class Solution {
    private int count(int[] nums,int i,int target, int sum){
        if(i<0){
            if(sum==target)return 1;
            return 0;
        }
        
        int sub = count(nums,i-1,target,sum-nums[i]);
        int add = count(nums,i-1,target,sum+nums[i]);
        return sub+add;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return count(nums,nums.length-1,target,0);
    }
}