class Solution {
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int maxDiff = -1;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min,nums[i]);
            if(nums[i]>min){
                maxDiff = Math.max(maxDiff,nums[i]-min);
            }
        }return maxDiff;
    }
}