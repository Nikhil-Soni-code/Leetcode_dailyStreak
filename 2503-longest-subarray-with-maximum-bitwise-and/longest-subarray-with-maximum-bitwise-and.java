class Solution {
    public int longestSubarray(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
        }
        int maxCount=0,count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max){
                count++;
            }
            else{
                maxCount = Math.max(maxCount , count);
                count=0;
            }
        }
        maxCount = Math.max(maxCount , count);
        return maxCount;
    }
}