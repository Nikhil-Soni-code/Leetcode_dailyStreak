class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = 0, min = Integer.MAX_VALUE;
        for(int i=0 ; i<nums.length ; i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        return (max-min)*k;
    }
}