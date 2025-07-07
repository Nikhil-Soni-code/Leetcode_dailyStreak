class Solution {
    private int find(int[] nums,int target,int i){
        if(i==0){
            if(target==0)return 1;
            return 0;
        }
        int sub = find(nums,target-nums[i-1],i-1);
        int add = find(nums,target+nums[i-1],i-1);
        return sub+add;
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        return find(nums,target,nums.length);
    }
}